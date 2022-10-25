import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class BinaryTreeDynamicNode {
  static class BinaryTree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
      }
    }

    private TreeNode root;

    private TreeNode buildTree(String[] nodes) { return buildTree(nodes, 0); }

    private TreeNode buildTree(String[] nodes, int currIdx) {
      if (currIdx >= nodes.length || nodes[currIdx].equalsIgnoreCase("null")) {
        return null;
      }

      TreeNode node = new TreeNode(Integer.parseInt(nodes[currIdx]));
      node.left = buildTree(nodes, 2 * currIdx + 1);
      node.right = buildTree(nodes, 2 * currIdx + 2);

      return node;
    }

    public BinaryTree(String[] nodes) { this.root = buildTree(nodes); }

    // O(n) / O(n)
    public void dfsPre() {
      if (root == null) {
        return;
      }

      dfsPre(root);
      System.out.println();
    }

    private void dfsPre(TreeNode node) {
      if (node == null) {
        return;
      }

      System.out.printf("%d ", node.val);

      if (node.left != null) {
        dfsPre(node.left);
      }

      if (node.right != null) {
        dfsPre(node.right);
      }
    }

    // O(n) / O(n)
    public void dfsPreIter() {
      if (root == null) {
        return;
      }

      dfsPreIter(root);
      System.out.println();
    }

    private void dfsPreIter(TreeNode node) {
      Stack<TreeNode> st = new Stack<>();
      st.push(node);

      while (!st.isEmpty()) {
        node = st.pop();

        System.out.printf("%d ", node.val);

        if (node.right != null) {
          st.push(node.right);
        }

        if (node.left != null) {
          st.push(node.left);
        }
      }
    }

    // O(n) / O(n)
    public void dfsIn() {
      if (root == null) {
        return;
      }

      dfsIn(root);
      System.out.println();
    }

    private void dfsIn(TreeNode node) {
      if (node == null) {
        return;
      }

      dfsIn(node.left);
      System.out.printf("%d ", node.val);
      dfsIn(node.right);
    }

    // O(n) / O(n)
    public void dfsInIter() {
      if (root == null) {
        return;
      }

      dfsInIter(root);
      System.out.println();
    }

    private void dfsInIter(TreeNode node) {
      Stack<TreeNode> st = new Stack<>();
      TreeNode currNode = node;

      while (currNode != null || !st.isEmpty()) {
        while (currNode != null) {
          st.push(currNode);
          currNode = currNode.left;
        }

        if (!st.isEmpty()) {
          currNode = st.pop();
          System.out.printf("%d ", currNode.val);
          currNode = currNode.right;
        }
      }
    }

    // O(n) / O(n)
    public void dfsPost() {
      if (root == null) {
        return;
      }

      dfsPost(root);
      System.out.println();
    }

    private void dfsPost(TreeNode node) {
      if (node == null) {
        return;
      }

      dfsPost(node.left);
      dfsPost(node.right);
      System.out.printf("%d ", node.val);
    }

    // O(n) / O(n)
    public void dfsPostIter() {
      if (root == null) {
        return;
      }

      dfsPostIter(root);
      System.out.println();
    }

    private void dfsPostIter(TreeNode node) {
      Stack<TreeNode> st = new Stack<>();
      Stack<TreeNode> revSt = new Stack<>();

      st.push(node);

      while (!st.isEmpty()) {
        node = st.pop();
        revSt.push(node);

        if (node.left != null) {
          st.push(node.left);
        }

        if (node.right != null) {
          st.push(node.right);
        }
      }

      while (!revSt.isEmpty()) {
        System.out.printf("%d ", revSt.pop().val);
      }
    }

    // O(n) / O(n)
    public void bfs() {
      if (root == null) {
        return;
      }

      Queue<TreeNode> q = new ArrayDeque<>();
      q.add(root);

      while (!q.isEmpty()) {
        TreeNode node = q.poll();

        System.out.printf("%d ", node.val);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      System.out.println();
    }

    // O(n) / O(n)
    public void bfsRec() {
      if (root == null) {
        return;
      }

      Queue<TreeNode> q = new ArrayDeque<>();
      q.add(root);

      bfsRec(q);
      System.out.println();
    }

    private void bfsRec(Queue<TreeNode> q) {
      if (q.isEmpty()) {
        return;
      }

      TreeNode node = q.poll();
      System.out.printf("%d ", node.val);

      if (node.left != null) {
        q.add(node.left);
      }

      if (node.right != null) {
        q.add(node.right);
      }

      bfsRec(q);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] nodes = in.nextLine().split(" ");
      BinaryTree tree = new BinaryTree(nodes);

      tree.dfsPre();
      tree.dfsPreIter();

      tree.dfsIn();
      tree.dfsInIter();

      tree.dfsPost();
      tree.dfsPostIter();

      tree.bfs();
      tree.bfsRec();
    }
  }
}