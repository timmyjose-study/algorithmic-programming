import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LevelAverages {
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
        var res = levelAverages(root);
        for (double r : res) {
          System.out.printf("%.1f ", r);
        }
        System.out.println();
      }
    }
  }

  // O(n) / O(1)
  public static List<Double> levelAverages(TreeNode root) {
    List<Double> res = new ArrayList<>();

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    double sum = 0.0;
    while (!q.isEmpty()) {
      int size = q.size();
      sum = 0.0;

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        sum += node.val;

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      res.add((sum / (double)size));
    }

    return res;
  }
}