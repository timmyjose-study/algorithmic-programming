import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }
        in.nextLine();

        TreeNode root = buildTree(nodes);
        System.out.println(hasSequence(root, a));
      }
    }
  }

  // O(n) / O(1)
  public static boolean hasSequence(TreeNode root, int[] a) {
    return hasSequence(root, 0, a);
  }

  private static boolean hasSequence(TreeNode root, int currIdx, int[] a) {
    if (root == null) {
      return false;
    }

    if (currIdx == a.length - 1 && a[currIdx] == root.val) {
      return true;
    }

    return a[currIdx] == root.val && (hasSequence(root.left, currIdx + 1, a) ||
                                      hasSequence(root.right, currIdx + 1, a));
  }
}