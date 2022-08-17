import java.util.*;
import java.util.function.*;

public class BinaryTreeDynamicNode {
  static class BinaryTree<T> {
    static class Node<T> {
      T data;
      Node<T> left;
      Node<T> right;

      Node(T data) {
        this.data = data;
        this.left = this.right = null;
      }
    }

    private Node<T> root;

    public BinaryTree() { this.root = null; }

    public void read(String[] nodes, Function<String, T> parser) {
      this.root = read(nodes, parser, 0);
    }

    private Node<T> read(String[] nodes, Function<String, T> parser, int idx) {
      if (nodes[idx].equals("null")) {
        return null;
      }

      Node<T> node = new Node<>(parser.apply(nodes[idx]));

      if (2 * idx + 1 < nodes.length) {
        node.left = read(nodes, parser, 2 * idx + 1);
      }

      if (2 * idx + 2 < nodes.length) {
        node.right = read(nodes, parser, 2 * idx + 2);
      }

      return node;
    }

    public void preOrder() {
      preOrder(this.root);
      System.out.println();
    }

    private void preOrder(Node<T> node) {
      if (node == null) {
        return;
      }

      System.out.print(node.data + " ");
      preOrder(node.left);
      preOrder(node.right);
    }

    public void preOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      st.push(this.root);

      while (!st.empty()) {
        Node<T> node = st.pop();

        System.out.print(node.data + " ");

        if (node.right != null) {
          st.push(node.right);
        }

        if (node.left != null) {
          st.push(node.left);
        }
      }

      System.out.println();
    }

    public void inOrder() {
      inOrder(this.root);
      System.out.println();
    }

    private void inOrder(Node<T> node) {
      if (node == null) {
        return;
      }

      inOrder(node.left);
      System.out.print(node.data + " ");
      inOrder(node.right);
    }

    public void inOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      Node<T> node = this.root;

      while (node != null || !st.empty()) {
        while (node != null) {
          st.push(node);
          node = node.left;
        }

        if (!st.empty()) {
          node = st.pop();
          System.out.print(node.data + " ");
          node = node.right;
        }
      }

      System.out.println();
    }

    public void postOrder() {
      postOrder(this.root);
      System.out.println();
    }

    private void postOrder(Node<T> node) {
      if (node == null) {
        return;
      }

      postOrder(node.left);
      postOrder(node.right);
      System.out.print(node.data + " ");
    }

    public void postOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      Stack<Node<T>> processed = new Stack<>();

      st.push(this.root);
      while (!st.empty()) {
        Node<T> node = st.pop();

        processed.push(node);

        if (node.left != null) {
          st.push(node.left);
        }

        if (node.right != null) {
          st.push(node.right);
        }
      }

      while (!processed.empty()) {
        Node<T> node = processed.pop();
        System.out.print(node.data + " ");
      }
      System.out.println();
    }

    public void bfs() {
      Queue<Node<T>> q = new ArrayDeque<>();
      q.add(this.root);

      while (!q.isEmpty()) {
        Node<T> node = q.poll();

        System.out.print(node.data + " ");

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
      System.out.println();
    }

    private int height() { return height(this.root); }

    private int height(Node<T> node) {
      if (node == null) {
        return 0;
      }
      return 1 + Math.max(height(node.left), height(node.right));
    }

    public void bfsRec() {
      int h = height();
      for (int i = 0; i < h; i++) {
        bfsRec(this.root, i);
      }
      System.out.println();
    }

    private void bfsRec(Node<T> node, int level) {
      if (node == null) {
        return;
      }

      if (level == 0) {
        System.out.print(node.data + " ");
      } else {
        bfsRec(node.left, level - 1);
        bfsRec(node.right, level - 1);
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