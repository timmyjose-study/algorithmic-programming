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

    public void build(String[] nodes, Function<String, T> parser) {
      this.root = buildRecursively(this.root, 0, nodes, parser);
    }

    private Node<T> buildRecursively(Node<T> root, int currIdx, String[] nodes,
                                     Function<String, T> parser) {
      if (currIdx >= nodes.length || nodes[currIdx].equals("null")) {
        return null;
      }

      if (root == null) {
        root = new Node<>(parser.apply(nodes[currIdx]));
      }

      root.left = buildRecursively(root.left, 2 * currIdx + 1, nodes, parser);
      root.right = buildRecursively(root.right, 2 * currIdx + 2, nodes, parser);

      return root;
    }

    public void dfsPreOrder() {
      dfsPreOrder(this.root);
      System.out.println();
    }

    private void dfsPreOrder(Node<T> root) {
      if (root == null) {
        return;
      }

      System.out.printf("%s ", root.data);
      dfsPreOrder(root.left);
      dfsPreOrder(root.right);
    }

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

    public void dfsInOrder() {
      dfsInOrder(this.root);
      System.out.println();
    }

    private void dfsInOrder(Node<T> root) {
      if (root == null) {
        return;
      }

      dfsInOrder(root.left);
      System.out.printf("%s ", root.data);
      dfsInOrder(root.right);
    }

    public void dfsInOrderIter() {
      Stack<Node<T>> st = new Stack<>();
      Node<T> currNode = this.root;

      while (currNode != null || !st.isEmpty()) {
        while (currNode != null) {
          st.push(currNode);
          currNode = currNode.left;
        }

        if (!st.isEmpty()) {
          currNode = st.pop();
          System.out.printf("%s ", currNode.data);
          currNode = currNode.right;
        }
      }
      System.out.println();
    }

    public void dfsPostOrder() {
      dfsPostOrder(this.root);
      System.out.println();
    }

    private void dfsPostOrder(Node<T> root) {
      if (root == null) {
        return;
      }

      dfsPostOrder(root.left);
      dfsPostOrder(root.right);
      System.out.printf("%s ", root.data);
    }

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

    public int height() { return height(this.root); }

    private int height(Node<T> root) {
      if (root == null) {
        return 0;
      }
      return 1 + Math.max(height(root.left), height(root.right));
    }

    public void bfsRec() {
      int h = height();
      for (int i = 0; i < h; i++) {
        bfsRec(this.root, i);
      }
      System.out.println();
    }

    private void bfsRec(Node<T> root, int level) {
      if (root == null) {
        return;
      }

      if (level == 0) {
        System.out.printf("%s ", root.data);
      } else {
        bfsRec(root.left, level - 1);
        bfsRec(root.right, level - 1);
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