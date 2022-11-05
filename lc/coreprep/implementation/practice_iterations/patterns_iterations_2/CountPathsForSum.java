import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CountPathsForSum {
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
        System.out.println(countPathsForsum(root, sum));
      }
    }
  }

  static class IntWrapper {
    int ival;

    IntWrapper(int ival) { this.ival = ival; }
  }

  // O(n2) / O(1)
  public static int countPathsForsum(TreeNode root, int sum) {
    IntWrapper totPaths = new IntWrapper(0);
    countPathsForsum(root, sum, totPaths, new ArrayList<>());

    return totPaths.ival;
  }

  private static void countPathsForsum(TreeNode root, int sum,
                                       IntWrapper totPaths,
                                       List<Integer> currPath) {
    if (root == null) {
      return;
    }

    currPath.add(root.val);

    int cnt = 0, currSum = 0;
    for (int i = 0; i < currPath.size() - 1; i++) {
      currSum = 0;
      for (int j = i; j < currPath.size(); j++) {
        currSum += currPath.get(j);

        if (currSum == sum) {
          cnt++;
          break;
        }
      }
    }

    totPaths.ival += cnt;

    countPathsForsum(root.left, sum, totPaths, currPath);
    countPathsForsum(root.right, sum, totPaths, currPath);
    currPath.remove(currPath.size() - 1);
  }
}