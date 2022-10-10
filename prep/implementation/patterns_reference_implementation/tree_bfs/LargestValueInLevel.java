import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
public class LargestValueInLevel {
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

  private static List<Integer> largestValueInLevel(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int levelSize = q.size();
      int maxVal = Integer.MIN_VALUE;

      for (int i = 0; i < levelSize; i++) {
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
    }

    return res;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);

        var res = largestValueInLevel(root);
        for (int r : res) {
          System.out.printf("%d\n", r);
        }
      }
    }
  }
}