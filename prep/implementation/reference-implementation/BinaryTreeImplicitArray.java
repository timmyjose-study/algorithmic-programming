import java.util.*;
import java.util.function.*;

public class BinaryTreeImplicitArray {
  static class BinaryTree<T> {
    static class Node<T> {
      T data;
      Node(T data) { this.data = data; }
    }

    private List<Node<T>> arr;
    private int size = 0;

    private static final int SIZE = 1024;

    public BinaryTree() {
      this.size = 0;
      this.arr = new ArrayList<>(BinaryTree.SIZE);

      for (int i = 0; i < BinaryTree.SIZE; i++) {
        this.arr.add(null);
      }
    }

    public void read(String[] nodes, Function<String, T> parser) {
      read(nodes, parser, 0);
    }

    private int left(int idx) { return 2 * idx + 1; }

    private int right(int idx) { return 2 * idx + 2; }

    private void read(String[] nodes, Function<String, T> parser, int idx) {
      if (nodes[idx].equals("null")) {
        this.arr.set(idx, null);
      } else {
        this.arr.set(idx, new Node<>(parser.apply(nodes[idx])));

        if (left(idx) < nodes.length) {
          read(nodes, parser, left(idx));
        }

        if (right(idx) < nodes.length) {
          read(nodes, parser, right(idx));
        }
      }
    }

    public void preOrder() {
      preOrder(0);
      System.out.println();
    }

    private void preOrder(int idx) {
      if (this.arr.get(idx) == null) {
        return;
      }

      System.out.print(this.arr.get(idx).data + " ");
      preOrder(left(idx));
      preOrder(right(idx));
    }

    public void preOrderIter() {
      Stack<Integer> st = new Stack<>();
      st.push(0);

      while (!st.empty()) {
        int idx = st.pop();
        System.out.print(this.arr.get(idx).data + " ");

        if (this.arr.get(right(idx)) != null) {
          st.push(right(idx));
        }

        if (this.arr.get(left(idx)) != null) {
          st.push(left(idx));
        }
      }
      System.out.println();
    }

    public void inOrder() {
      inOrder(0);
      System.out.println();
    }

    private void inOrder(int idx) {
      if (this.arr.get(idx) == null) {
        return;
      }

      inOrder(left(idx));
      System.out.print(this.arr.get(idx).data + " ");
      inOrder(right(idx));
    }

    public void inOrderIter() {
      Stack<Integer> st = new Stack<>();
      int idx = 0;

      while (this.arr.get(idx) != null || !st.empty()) {
        while (this.arr.get(idx) != null) {
          st.push(idx);
          idx = left(idx);
        }

        if (!st.empty()) {
          idx = st.pop();
          System.out.print(this.arr.get(idx).data + " ");
          idx = right(idx);
        }
      }
      System.out.println();
    }

    public void postOrder() {
      postOrder(0);
      System.out.println();
    }

    private void postOrder(int idx) {
      if (this.arr.get(idx) == null) {
        return;
      }

      postOrder(left(idx));
      postOrder(right(idx));
      System.out.print(this.arr.get(idx).data + " ");
    }

    public void postOrderIter() {
      Stack<Integer> st = new Stack<>();
      Stack<Integer> processed = new Stack<>();

      st.push(0);
      while (!st.empty()) {
        int idx = st.pop();
        processed.push(idx);

        if (this.arr.get(left(idx)) != null) {
          st.push(left(idx));
        }

        if (this.arr.get(right(idx)) != null) {
          st.push(right(idx));
        }
      }

      while (!processed.empty()) {
        System.out.print(this.arr.get(processed.pop()).data + " ");
      }
      System.out.println();
    }

    public void bfs() {
      Queue<Integer> q = new ArrayDeque<>();
      q.add(0);

      while (!q.isEmpty()) {
        int idx = q.poll();
        System.out.print(this.arr.get(idx).data + " ");

        if (this.arr.get(left(idx)) != null) {
          q.add(left(idx));
        }

        if (this.arr.get(right(idx)) != null) {
          q.add(right(idx));
        }
      }
      System.out.println();
    }

    private int height() { return height(0); }

    private int height(int idx) {
      if (this.arr.get(idx) == null) {
        return 0;
      }

      return 1 + Math.max(height(left(idx)), height(right(idx)));
    }

    public void bfsRec() {
      int h = height();
      for (int i = 0; i < h; i++) {
        bfsRec(0, i);
      }
      System.out.println();
    }

    private void bfsRec(int idx, int level) {
      if (this.arr.get(idx) == null) {
        return;
      }

      if (level == 0) {
        System.out.print(this.arr.get(idx).data + " ");
      } else {
        bfsRec(left(idx), level - 1);
        bfsRec(right(idx), level - 1);
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      BinaryTree<Integer> tree = new BinaryTree<>();
      String[] nodes = in.nextLine().trim().split(" ");

      tree.read(nodes, Integer::parseInt);

      tree.preOrder();
      tree.preOrderIter();

      tree.inOrder();
      tree.inOrderIter();

      tree.postOrder();
      tree.postOrderIter();

      tree.bfs();
      tree.bfsRec();
    }
  }
}