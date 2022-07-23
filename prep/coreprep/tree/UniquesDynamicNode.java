import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UniquesDynamicNode {
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
      Node<T> left;
      Node<T> right;

      Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
      }
    }

    private Node<T> root;

    BST() { this.root = null; }

    public void insert(T elem) { this.root = insertRecursive(this.root, elem); }

    private Node<T> insertRecursive(Node<T> root, T elem) {
      if (root == null) {
        root = new Node<>(elem);
      } else if (elem.compareTo(root.data) < 0) {
        root.left = insertRecursive(root.left, elem);
      } else if (elem.compareTo(root.data) > 0) {
        root.right = insertRecursive(root.right, elem);
      }

      return root;
    }

    public void preOrder() {
      preOrderHelper(this.root);
      System.out.println();
    }

    private void preOrderHelper(Node<T> root) {
      if (root == null) {
        return;
      }

      System.out.print(root.data + " ");
      preOrderHelper(root.left);
      preOrderHelper(root.right);
    }

    public void preOrderIter() {
      if (this.root == null) {
        return;
      }

      Stack<Node<T>> st = new Stack<>();
      Node<T> currNode = this.root;
      st.push(currNode);

      while (!st.empty()) {
        currNode = st.pop();
        System.out.print(currNode.data + " ");

        if (currNode.right != null) {
          st.push(currNode.right);
        }

        if (currNode.left != null) {
          st.push(currNode.left);
        }
      }
      System.out.println();
    }

    public void inOrder() {
      inOrderHelper(this.root);
      System.out.println();
    }

    private void inOrderHelper(Node<T> root) {
      if (root == null) {
        return;
      }

      inOrderHelper(root.left);
      System.out.print(root.data + " ");
      inOrderHelper(root.right);
    }

    public void inOrderIter() {
      if (this.root == null) {
        return;
      }

      Stack<Node<T>> st = new Stack<>();
      Node<T> currNode = this.root;

      while (currNode != null || !st.empty()) {
        while (currNode != null) {
          st.push(currNode);
          currNode = currNode.left;
        }

        if (!st.empty()) {
          currNode = st.pop();
          System.out.print(currNode.data + " ");
          currNode = currNode.right;
        }
      }
      System.out.println();
    }

    public void postOrder() {
      postOrderHelper(this.root);
      System.out.println();
    }

    private void postOrderHelper(Node<T> root) {
      if (root == null) {
        return;
      }

      postOrderHelper(root.left);
      postOrderHelper(root.right);
      System.out.print(root.data + " ");
    }

    public void postOrderIter() {
      if (this.root == null) {
        return;
      }

      Stack<Node<T>> st = new Stack<>();
      Stack<T> processed = new Stack<>();
      Node<T> currNode = this.root;

      st.push(currNode);
      while (!st.empty()) {
        currNode = st.pop();
        processed.push(currNode.data);

        if (currNode.left != null) {
          st.push(currNode.left);
        }

        if (currNode.right != null) {
          st.push(currNode.right);
        }
      }

      while (!processed.empty()) {
        System.out.print(processed.pop() + " ");
      }
      System.out.println();
    }

    public void bfs() {
      if (this.root == null) {
        return;
      }

      Queue<Node<T>> q = new ArrayDeque<>();
      Node<T> currNode = this.root;

      q.add(currNode);

      while (!q.isEmpty()) {
        currNode = q.remove();
        System.out.print(currNode.data + " ");

        if (currNode.left != null) {
          q.add(currNode.left);
        }

        if (currNode.right != null) {
          q.add(currNode.right);
        }
      }
      System.out.println();
    }
  }
}