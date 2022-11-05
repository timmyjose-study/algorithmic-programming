import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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
        System.out.println(sumOfPathNumbers(root));
      }
    }
  }

  static class IntWrapper {
    int ival;

    IntWrapper(int ival) { this.ival = ival; }
  }

  public static int sumOfPathNumbers(TreeNode root) {
    IntWrapper totSum = new IntWrapper(0);
    sumOfPathNumbers(root, 0, totSum);

    return totSum.ival;
  }

  // O(n) / O(1)
  private static void sumOfPathNumbers(TreeNode root, int currSum,
                                       IntWrapper totSum) {
    if (root == null) {
      return;
    }

    currSum = 10 * currSum + root.val;

    if (root.left == null && root.right == null) {
      totSum.ival += currSum;
    }

    sumOfPathNumbers(root.left, currSum, totSum);
    sumOfPathNumbers(root.right, currSum, totSum);
  }
}