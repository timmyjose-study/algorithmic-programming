import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
public class PathWithGivenSequence {
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

  private static boolean hasPathWithSequence(TreeNode root, int[] a) {
    if (root == null) {
      return a.length == 0;
    }

    return hasPathWithSequence(root, a, 0);
  }

  private static boolean hasPathWithSequence(TreeNode root, int[] a,
                                             int currIdx) {
    if (root == null) {
      return false;
    }

    if (currIdx >= a.length || a[currIdx] != root.val) {
      return false;
    }

    if (root.left == null && root.right == null && currIdx == a.length - 1) {
      return true;
    }

    return hasPathWithSequence(root.left, a, currIdx + 1) ||
        hasPathWithSequence(root.right, a, currIdx + 1);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        in.nextLine();
        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(hasPathWithSequence(root, a));
      }
    }
  }
}