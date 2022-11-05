import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AllPathsForSum {
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
        var res = allPathsForSum(root, sum);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(nlogn) / O(n)
  public static List<List<Integer>> allPathsForSum(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    allPathsForSum(root, sum, new ArrayList<>(), allPaths);

    return allPaths;
  }

  private static void allPathsForSum(TreeNode root, int sum,
                                     List<Integer> currPath,
                                     List<List<Integer>> allPaths) {
    if (root == null) {
      return;
    }

    currPath.add(root.val);

    if (root.left == null && root.right == null && root.val == sum) {
      allPaths.add(new ArrayList<>(currPath));
    }

    allPathsForSum(root.left, sum - root.val, currPath, allPaths);
    allPathsForSum(root.right, sum - root.val, currPath, allPaths);
    currPath.remove(currPath.size() - 1);
  }
}