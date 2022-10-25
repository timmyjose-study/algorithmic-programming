import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
public class SumOfPathNumbers {
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
    return buildTree(nodes, 0);
  }

  private static TreeNode buildTree(String[] nodes, int currIdx) {
    if (currIdx >= nodes.length || nodes[currIdx].equalsIgnoreCase("null")) {
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(nodes[currIdx]));
    root.left = buildTree(nodes, 2 * currIdx + 1);
    root.right = buildTree(nodes, 2 * currIdx + 2);

    return root;
  }

  private static int sumOfPathNumbers(TreeNode root) {
    return sumOfPathNumbers(root, 0);
  }

  private static int sumOfPathNumbers(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    int currSum = 10 * sum + root.val;

    if (root.left == null && root.right == null) {
      return currSum;
    }

    return sumOfPathNumbers(root.left, currSum) +
        sumOfPathNumbers(root.right, currSum);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);
        System.out.println(sumOfPathNumbers(root));
      }
    }
  }
}