import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(n)
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

  private static int countPathsForSum(TreeNode root, int sum) {
    List<Integer> currPath = new ArrayList<>();
    return countPathsForSum(root, sum, currPath);
  }

  private static int countPathsForSum(TreeNode root, int sum,
                                      List<Integer> currPath) {
    if (root == null) {
      return 0;
    }

    currPath.add(root.val);

    int pathSum = 0, pathCount = 0;
    for (int i = currPath.size() - 1; i >= 0; i--) {
      pathSum += currPath.get(i);

      if (pathSum == sum) {
        pathCount++;
      }
    }

    pathCount += countPathsForSum(root.left, sum, currPath);
    pathCount += countPathsForSum(root.right, sum, currPath);

    currPath.remove(currPath.size() - 1);

    return pathCount;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int sum = in.nextInt();
        in.nextLine();

        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);
        System.out.println(countPathsForSum(root, sum));
      }
    }
  }
}