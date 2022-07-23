import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class BinaryTreeImplicitArray {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      BinaryTree<Integer> tree = new BinaryTree<>();

      String[] nodes = in.nextLine().trim().split(" ");
      tree.read(nodes, Integer::parseInt);

      System.out.println("Height of tree = " + tree.height());

      tree.preOrder();
      tree.preOrderIter();

      tree.inOrder();
      tree.inOrderIter();

      tree.postOrder();
      tree.postOrderIter();

      tree.bfs();
    }
  }

  static class BinaryTree<T extends Comparable<T>> {
    static class Node<T> {
      T data;
      Node(T data) { this.data = data; }
    }

    private static final int SIZE = 1024;
    private List<Node<T>> arr = null;
    private int rootIndex = 0;

    public BinaryTree() {
      this.arr = new ArrayList<>(BinaryTree.SIZE);
      for (int i = 0; i < BinaryTree.SIZE; i++) {
        arr.add(null);
      }
    }

    private int left(int index) { return 2 * index + 1; }
    private int right(int index) { return 2 * index + 2; }

    public void read(String[] nodes, Function<String, T> parser) {
      readRecursively(nodes, this.rootIndex, parser);
    }

    private void readRecursively(String[] nodes, int rootIndex,
                                 Function<String, T> parser) {
      if (!nodes[rootIndex].equals("null")) {
        this.arr.set(rootIndex, new Node<>(parser.apply(nodes[rootIndex])));

        if (left(rootIndex) < nodes.length) {
          readRecursively(nodes, left(rootIndex), parser);
        }

        if (right(rootIndex) < nodes.length) {
          readRecursively(nodes, right(rootIndex), parser);
        }
      }
    }

    public int height() { return heightRecursive(0) - 1; }

    private int heightRecursive(int rootIndex) {
      if (this.arr.get(rootIndex) == null) {
        return 0;
      }

      return 1 + Math.max(heightRecursive(left(rootIndex)),
                          heightRecursive(right(rootIndex)));
    }

    public void preOrder() {
      preOrderRecursive(0);
      System.out.println();
    }

    private void preOrderRecursive(int rootIndex) {
      if (this.arr.get(rootIndex) == null) {
        return;
      }

      System.out.print(this.arr.get(rootIndex).data + " ");
      preOrderRecursive(left(rootIndex));
      preOrderRecursive(right(rootIndex));
    }

    public void preOrderIter() {
      if (this.arr.get(0) == null) {
        return;
      }

      Stack<Integer> st = new Stack<>();
      int rootIndex = 0;
      st.push(rootIndex);

      while (!st.empty()) {
        rootIndex = st.pop();

        System.out.print(this.arr.get(rootIndex).data + " ");

        if (this.arr.get(right(rootIndex)) != null) {
          st.push(right(rootIndex));
        }

        if (this.arr.get(left(rootIndex)) != null) {
          st.push(left(rootIndex));
        }
      }
      System.out.println();
    }

    public void inOrder() {
      inOrderRecursive(0);
      System.out.println();
    }

    private void inOrderRecursive(int rootIndex) {
      if (this.arr.get(rootIndex) == null) {
        return;
      }

      inOrderRecursive(left(rootIndex));
      System.out.print(this.arr.get(rootIndex).data + " ");
      inOrderRecursive(right(rootIndex));
    }

    public void inOrderIter() {
      if (this.arr.get(0) == null) {
        return;
      }

      Stack<Integer> st = new Stack<>();
      int rootIndex = 0;

      while (this.arr.get(rootIndex) != null || !st.empty()) {
        while (this.arr.get(rootIndex) != null) {
          st.push(rootIndex);
          rootIndex = left(rootIndex);
        }

        if (!st.empty()) {
          rootIndex = st.pop();
          System.out.print(this.arr.get(rootIndex).data + " ");
          rootIndex = right(rootIndex);
        }
      }
      System.out.println();
    }

    public void postOrder() {
      postOrderRecursive(0);
      System.out.println();
    }

    private void postOrderRecursive(int rootIndex) {
      if (this.arr.get(rootIndex) == null) {
        return;
      }

      postOrderRecursive(left(rootIndex));
      postOrderRecursive(right(rootIndex));
      System.out.print(this.arr.get(rootIndex).data + " ");
    }

    public void postOrderIter() {
      if (this.arr.get(0) == null) {
        return;
      }

      int rootIndex = 0;
      Stack<Integer> st = new Stack<>();
      Stack<T> processed = new Stack<>();
      st.push(rootIndex);

      while (!st.empty()) {
        rootIndex = st.pop();

        processed.add(this.arr.get(rootIndex).data);

        if (this.arr.get(left(rootIndex)) != null) {
          st.push(left(rootIndex));
        }

        if (this.arr.get(right(rootIndex)) != null) {
          st.push(right(rootIndex));
        }
      }

      while (!processed.empty()) {
        System.out.print(processed.pop() + " ");
      }
      System.out.println();
    }

    public void bfs() {
      if (this.arr.get(0) == null) {
        return;
      }

      Queue<Integer> q = new ArrayDeque<>();
      int rootIndex = 0;
      q.add(rootIndex);

      while (!q.isEmpty()) {
        rootIndex = q.remove();
        System.out.print(this.arr.get(rootIndex).data + " ");

        if (this.arr.get(left(rootIndex)) != null) {
          q.add(left(rootIndex));
        }

        if (this.arr.get(right(rootIndex)) != null) {
          q.add(right(rootIndex));
        }
      }
      System.out.println();
    }
  }
}