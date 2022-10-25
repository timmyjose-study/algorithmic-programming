import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UniquesImplicitArray {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      BST<Integer> bst = new BST<>();
      int n = in.nextInt();
      for (int i = 0; i < n; i++) {
        bst.insert(in.nextInt());
      }

      bst.preOrder();
      bst.preOrderIter();

      bst.inOrder();
      bst.inOrderIter();

      bst.postOrder();
      bst.postOrderIter();

      bst.bfs();
    }
  }

  static class BST<T extends Comparable<T>> {
    static class Node<T> {
      T data;

      Node(T data) { this.data = data; }
    }

    private static final int SIZE = 1024;
    private List<Node<T>> arr;

    public BST() {
      this.arr = new ArrayList<>(BST.SIZE);
      for (int i = 0; i < BST.SIZE; i++) {
        this.arr.add(null);
      }
    }

    private int left(int index) { return 2 * index + 1; }
    private int right(int index) { return 2 * index + 2; }

    public void insert(T elem) { insertRecursive(0, elem); }

    private void insertRecursive(int rootIndex, T elem) {
      if (this.arr.get(rootIndex) == null) {
        this.arr.set(rootIndex, new Node<>(elem));
      } else if (elem.compareTo(this.arr.get(rootIndex).data) < 0) {
        insertRecursive(left(rootIndex), elem);
      } else if (elem.compareTo(this.arr.get(rootIndex).data) > 0) {
        insertRecursive(right(rootIndex), elem);
      }
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
      st.push(0);

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

      Stack<Integer> st = new Stack<>();
      Stack<T> processed = new Stack<>();
      int rootIndex = 0;

      st.push(0);
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
      q.add(0);

      while (!q.isEmpty()) {
        int rootIndex = q.remove();
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