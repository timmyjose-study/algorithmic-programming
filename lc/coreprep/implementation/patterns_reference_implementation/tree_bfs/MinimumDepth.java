import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
public class MinimumDepth {
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

  private static int minDepth(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return 0;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    int minDepth = 0;
    while (!q.isEmpty()) {
      minDepth++;

      int levelSize = q.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = q.poll();

        if (node.left == null && node.right == null) {
          return minDepth;
        }

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
    }

    return minDepth;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);
        System.out.printf("%d\n", minDepth(root));
      }
    }
  }
}