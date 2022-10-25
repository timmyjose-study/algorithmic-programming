import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n2logn) / O(nlogn)
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

  private static List<List<Integer>> getPathsForSum(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    getPathsForSum(root, sum, currPath, allPaths);

    return allPaths;
  }

  private static void getPathsForSum(TreeNode root, int sum,
                                     List<Integer> currPath,
                                     List<List<Integer>> allPaths) {
    if (root == null) {
      return;
    }

    currPath.add(root.val);

    int pathSum = 0;
    for (int i = currPath.size() - 1; i >= 0; i--) {
      pathSum += currPath.get(i);

      if (pathSum == sum) {
        List<Integer> lst = new LinkedList<>();
        for (int j = currPath.size() - 1; j >= i; j--) {
          lst.add(0, currPath.get(j));
        }
        allPaths.add(new ArrayList<>(lst));
      }
    }

    getPathsForSum(root.left, sum, currPath, allPaths);
    getPathsForSum(root.right, sum, currPath, allPaths);

    currPath.remove(currPath.size() - 1);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int sum = in.nextInt();
        in.nextLine();

        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);

        var res = getPathsForSum(root, sum);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }
}