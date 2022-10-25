import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class BinaryTreeDynamicNode {
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
    }
  }

  static class BinaryTree<T extends Comparable<T>> {
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

    public void read(String[] nodes, Function<String, T> parser) {
      this.root = readRecursively(nodes, 0, parser);
    }

    private Node<T> readRecursively(String[] nodes, int rootIndex,
                                    Function<String, T> parser) {
      if (nodes[rootIndex].equals("null")) {
        return null;
      }

      Node<T> node = new Node<>(parser.apply(nodes[rootIndex]));
      if (rootIndex * 2 + 1 < nodes.length) {
        node.left = readRecursively(nodes, rootIndex * 2 + 1, parser);
      }

      if (rootIndex * 2 + 2 < nodes.length) {
        node.right = readRecursively(nodes, rootIndex * 2 + 2, parser);
      }

      return node;
    }

    public void preOrder() {
      preOrderRecursive(this.root);
      System.out.println();
    }

    private void preOrderRecursive(Node<T> root) {
      if (root == null) {
        return;
      }

      System.out.print(root.data + " ");
      preOrderRecursive(root.left);
      preOrderRecursive(root.right);
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
      inOrderRecursive(this.root);
      System.out.println();
    }

    private void inOrderRecursive(Node<T> root) {
      if (root == null) {
        return;
      }

      inOrderRecursive(root.left);
      System.out.print(root.data + " ");
      inOrderRecursive(root.right);
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
      postOrderRecursive(this.root);
      System.out.println();
    }

    private void postOrderRecursive(Node<T> root) {
      if (root == null) {
        return;
      }

      postOrderRecursive(root.left);
      postOrderRecursive(root.right);
      System.out.print(root.data + " ");
    }

    public void postOrderIter() {
      if (this.root == null) {
        return;
      }

      Node<T> currNode = this.root;
      Stack<Node<T>> st = new Stack<>();
      Stack<T> processed = new Stack<>();

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

      Node<T> currNode = this.root;
      Queue<Node<T>> q = new ArrayDeque<>();

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