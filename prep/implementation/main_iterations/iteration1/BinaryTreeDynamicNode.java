import java.util.*;
import java.util.function.Function;

public class BinaryTreeDynamicNode {
  static class BinaryTree<T> {
    static class Node<T> {
      T data;
      Node<T> left;
      Node<T> right;

      Node(T data) {
        this.data = data;
        this.left = left;
        this.right = right;
      }
    }

    private Node<T> root;

    BinaryTree() { this.root = null; }

    public void build(String[] nodes, Function<String, T> parser) {
      this.root = build(this.root, nodes, 0, parser);
    }

    private Node<T> build(Node<T> node, String[] nodes, int currIdx,
                          Function<String, T> parser) {

      if (currIdx >= nodes.length || nodes[currIdx].equals("null")) {
        return null;
      }

      if (node == null) {
        node = new Node<>(parser.apply(nodes[currIdx]));
      }

      node.left = build(node.left, nodes, 2 * currIdx + 1, parser);
      node.right = build(node.right, nodes, 2 * currIdx + 2, parser);

      return node;
    }

    public int height() { return height(this.root); }

    private int height(Node<T> node) {
      if (node == null) {
        return 0;
      }

      return 1 + Math.max(height(node.left), height(node.right));
    }

    // O(n)
    public void dfsPreOrder() {
      dfsPreOrder(this.root);
      System.out.println();
    }

    private void dfsPreOrder(Node<T> node) {
      if (node == null) {
        return;
      }

      System.out.printf("%s ", node.data);
      dfsPreOrder(node.left);
      dfsPreOrder(node.right);
    }

    // O(n)
    public void dfsPreOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      st.push(this.root);

      while (!st.isEmpty()) {
        Node<T> node = st.pop();
        System.out.printf("%s ", node.data);

        if (node.right != null) {
          st.push(node.right);
        }

        if (node.left != null) {
          st.push(node.left);
        }
      }
      System.out.println();
    }

    // O(n)
    public void dfsInOrder() {
      dfsInOrder(this.root);
      System.out.println();
    }

    private void dfsInOrder(Node<T> node) {
      if (node == null) {
        return;
      }

      dfsInOrder(node.left);
      System.out.printf("%s ", node.data);
      dfsInOrder(node.right);
    }

    // O(n)
    public void dfsInOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      Node<T> currNode = this.root;

      while (currNode != null || !st.isEmpty()) {
        while (currNode != null) {
          st.push(currNode);
          currNode = currNode.left;
        }

        currNode = st.pop();
        System.out.printf("%s ", currNode.data);
        currNode = currNode.right;
      }
      System.out.println();
    }

    // O(n)
    public void dfsPostOrder() {
      dfsPostOrder(this.root);
      System.out.println();
    }

    private void dfsPostOrder(Node<T> node) {
      if (node == null) {
        return;
      }

      dfsPostOrder(node.left);
      dfsPostOrder(node.right);
      System.out.printf("%s ", node.data);
    }

    // O(n)
    public void dfsPostOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      Stack<Node<T>> revSt = new Stack<>();

      st.push(this.root);
      while (!st.isEmpty()) {
        Node<T> node = st.pop();
        revSt.push(node);

        if (node.left != null) {
          st.push(node.left);
        }

        if (node.right != null) {
          st.push(node.right);
        }
      }

      while (!revSt.isEmpty()) {
        System.out.printf("%s ", revSt.pop().data);
      }
      System.out.println();
    }

    // O(|n})
    public void bfs() {
      Queue<Node<T>> q = new ArrayDeque<>();
      q.add(this.root);

      while (!q.isEmpty()) {
        Node<T> node = q.poll();

        System.out.printf("%s ", node.data);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
      System.out.println();
    }

    // O(n)
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
        System.out.printf("%d ", node.data);
      } else {
        bfsRec(node.left, level - 1);
        bfsRec(node.right, level - 1);
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] nodes = in.nextLine().trim().split(" ");

      BinaryTree<Integer> tree = new BinaryTree<>();
      tree.build(nodes, Integer::parseInt);

      tree.dfsPreOrder();
      tree.dfsPreOrderIter();
      tree.dfsInOrder();
      tree.dfsInOrderIter();
      tree.dfsPostOrder();
      tree.dfsPostOrderIter();
      tree.bfs();
      tree.bfsRec();
    }
  }
}