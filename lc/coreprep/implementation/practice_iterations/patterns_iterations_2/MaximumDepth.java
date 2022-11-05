import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaximumDepth {
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
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");

        TreeNode root = buildTree(nodes);
        System.out.println(maximumDepth(root));
      }
    }
  }

  // O(n) / O(1)
  public static int maximumDepth(TreeNode root) {
    int maxLevel = Integer.MIN_VALUE;
    int level = 0;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      level++;

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        if (node.left == null && node.right == null) {
          maxLevel = Math.max(maxLevel, level);
        }

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
    }

    return maxLevel;
  }
}