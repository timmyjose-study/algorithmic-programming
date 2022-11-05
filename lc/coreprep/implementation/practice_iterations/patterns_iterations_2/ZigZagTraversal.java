import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ZigZagTraversal {
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
        var res = zigZagTraversal(root);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // OIn) / O(1)
  public static List<List<Integer>> zigZagTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    boolean leftToRight = true;

    while (!q.isEmpty()) {
      int size = q.size();

      List<Integer> level = null;

      if (leftToRight) {
        level = new ArrayList<>();
      } else {
        level = new LinkedList<>();
      }

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        if (leftToRight) {
          level.add(node.val);
        } else {
          level.add(0, node.val);
        }

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      res.add(level);

      if (leftToRight) {
        leftToRight = false;
      } else {
        leftToRight = true;
      }
    }

    return res;
  }
}