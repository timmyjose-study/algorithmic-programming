import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LevelOrderSuccessor {
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

  private static TreeNode buildTree(String[] nodes) {
    return buildTree(0, nodes);
  }

  private static TreeNode buildTree(int currIdx, String[] nodes) {
    if (currIdx >= nodes.length || nodes[currIdx].equalsIgnoreCase("null")) {
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(nodes[currIdx]));
    node.left = buildTree(2 * currIdx + 1, nodes);
    node.right = buildTree(2 * currIdx + 2, nodes);

    return node;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int k = in.nextInt();
        in.nextLine();

        String[] nodes = in.nextLine().trim().split(" ");

        TreeNode root = buildTree(nodes);
        System.out.println(levelOrderSuccessor(root, k));
      }
    }
  }

  // O(n) / O(1)
  public static int levelOrderSuccessor(TreeNode root, int k) {
    TreeNode prev = null;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        if (prev != null && prev.val == k) {
          return node.val;
        }

        if (node.val == k) {
          prev = node;
        }

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
    }

    return Integer.MIN_VALUE;
  }
}