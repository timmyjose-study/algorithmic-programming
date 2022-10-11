import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(nlogn)
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

  static class Int {
    int val;
    Int(int val) { this.val = val; }
  }

  private static List<Integer> maxSumPathFromRootToLeaf(TreeNode root) {
    List<Integer> maxPath = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    Int maxSum = new Int(Integer.MIN_VALUE);

    maxSumPathFromRootToLeaf(root, 0, maxSum, currPath, maxPath);

    return maxPath;
  }

  private static void maxSumPathFromRootToLeaf(TreeNode root, int currSum,
                                               Int maxSum,
                                               List<Integer> currPath,
                                               List<Integer> maxPath) {
    if (root == null) {
      return;
    }

    currSum += root.val;
    currPath.add(root.val);

    if (root.left == null && root.right == null) {
      if (currSum > maxSum.val) {
        maxSum.val = currSum;

        maxPath.clear();
        for (int e : currPath) {
          maxPath.add(e);
        }
      }
    } else {
      maxSumPathFromRootToLeaf(root.left, currSum, maxSum, currPath, maxPath);
      maxSumPathFromRootToLeaf(root.right, currSum, maxSum, currPath, maxPath);
    }

    currPath.remove(currPath.size() - 1);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);
        var res = maxSumPathFromRootToLeaf(root);
        for (int e : res) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }
}