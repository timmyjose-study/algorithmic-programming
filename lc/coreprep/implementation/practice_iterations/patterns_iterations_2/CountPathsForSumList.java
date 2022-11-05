import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CountPathsForSumList {
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

  // O(n3) / O(n)
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

    for (int i = 0; i < currPath.size() - 1; i++) {
      int currSum = 0;
      for (int j = i; j < currPath.size(); j++) {
        currSum += currPath.get(j);

        if (currSum == sum) {
          List<Integer> sumPath = new ArrayList<>();
          for (int k = i; k <= j; k++) {
            sumPath.add(currPath.get(k));
          }
          allPaths.add(sumPath);
        }
      }
    }

    allPathsForSum(root.left, sum, currPath, allPaths);
    allPathsForSum(root.right, sum, currPath, allPaths);
    currPath.remove(currPath.size() - 1);
  }
}