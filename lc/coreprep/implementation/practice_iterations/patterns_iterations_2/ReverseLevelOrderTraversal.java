import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ReverseLevelOrderTraversal {
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

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");

        TreeNode root = buildTree(nodes);
        var res = reverseLevelOrderTraversal(root);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
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

  // O(n) / O(1)
  public static List<List<Integer>> reverseLevelOrderTraversal(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();

      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        level.add(node.val);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      res.add(0, level);
    }

    return res;
  }
}