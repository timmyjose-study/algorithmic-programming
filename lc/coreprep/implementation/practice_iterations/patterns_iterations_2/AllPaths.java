import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AllPaths {
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
        var res = allPaths(root);
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
  public static List<List<Integer>> allPaths(TreeNode root) {
    List<List<Integer>> allPaths = new ArrayList<>();
    allPaths(root, new ArrayList<>(), allPaths);

    return allPaths;
  }

  private static void allPaths(TreeNode root, List<Integer> currPath,
                               List<List<Integer>> allPaths) {
    if (root == null) {
      return;
    }

    currPath.add(root.val);

    if (root.left == null && root.right == null) {
      allPaths.add(new ArrayList<>(currPath));
    }

    allPaths(root.left, currPath, allPaths);
    allPaths(root.right, currPath, allPaths);
    currPath.remove(currPath.size() - 1);
  }
}