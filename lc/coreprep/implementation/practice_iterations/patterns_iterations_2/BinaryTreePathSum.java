import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class BinaryTreePathSum {
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
        int sum = in.nextInt();
        in.nextLine();

        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);
        System.out.println(hasPathWithSum(root, sum));
      }
    }
  }

  // O(n) / O(1)
  public static boolean hasPathWithSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return root.val == sum;
    }

    return hasPathWithSum(root.left, sum - root.val) ||
        hasPathWithSum(root.right, sum - root.val);
  }
}