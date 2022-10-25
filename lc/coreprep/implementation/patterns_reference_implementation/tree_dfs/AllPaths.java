import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(nlogn)
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

  private static List<List<Integer>> allPathsFromRootToLeaf(TreeNode root) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    allPathsFromRootToLeaf(root, currPath, allPaths);

    return allPaths;
  }

  private static void allPathsFromRootToLeaf(TreeNode root,
                                             List<Integer> currPath,
                                             List<List<Integer>> allPaths) {
    if (root == null) {
      return;
    }

    currPath.add(root.val);

    if (root.left == null && root.right == null) {
      allPaths.add(new ArrayList<>(currPath));
    } else {
      allPathsFromRootToLeaf(root.left, currPath, allPaths);
      allPathsFromRootToLeaf(root.right, currPath, allPaths);
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
        var res = allPathsFromRootToLeaf(root);
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