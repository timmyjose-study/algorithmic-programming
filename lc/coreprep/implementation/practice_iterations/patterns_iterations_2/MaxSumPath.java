import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaxSumPath {
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
        var res = maxSumPath(root);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  static class IntWrapper {
    int ival;

    IntWrapper(int ival) { this.ival = ival; }
  }

  // O(nlogn) / O(n)
  public static List<Integer> maxSumPath(TreeNode root) {
    List<Integer> maxPath = new ArrayList<>();
    IntWrapper maxSum = new IntWrapper(Integer.MIN_VALUE);

    maxSumPath(root, 0, maxSum, new ArrayList<>(), maxPath);

    return maxPath;
  }

  private static void maxSumPath(TreeNode root, int currSum, IntWrapper maxSum,
                                 List<Integer> currPath,
                                 List<Integer> maxPath) {
    if (root == null) {
      return;
    }

    currPath.add(root.val);
    currSum += root.val;

    if (root.left == null && root.right == null) {
      if (currSum > maxSum.ival) {
        maxSum.ival = currSum;
        maxPath.clear();
        for (int p : currPath) {
          maxPath.add(p);
        }
      }
    }

    maxSumPath(root.left, currSum, maxSum, currPath, maxPath);
    maxSumPath(root.right, currSum, maxSum, currPath, maxPath);
    currPath.remove(currPath.size() - 1);
  }
}