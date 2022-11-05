import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaxLevelValue {
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
        var res = levelMaximums(root);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(n) / O(1)
  public static List<Integer> levelMaximums(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    int maxVal = Integer.MIN_VALUE;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        maxVal = Math.max(maxVal, node.val);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      res.add(maxVal);
      maxVal = Integer.MIN_VALUE;
    }

    return res;
  }
}