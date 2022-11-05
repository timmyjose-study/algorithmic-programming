import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ConnectLevelOrderSiblings {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
      this.next = null;
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
        connectLevelOrderSiblings(root);
        displayLevelwise(root);
      }
    }
  }

  // O(n) / O(n)
  public static void connectLevelOrderSiblings(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();

      List<TreeNode> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        level.add(node);

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      for (int i = 0; i < level.size() - 1; i++) {
        level.get(i).next = level.get(i + 1);
      }
    }
  }

  private static void displayLevelwise(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();

      TreeNode node = q.poll();

      if (node.left != null) {
        q.add(node.left);
      } else if (node.right != null) {
        q.add(node.right);
      }

      while (node != null) {
        System.out.printf("%d ", node.val);
        node = node.next;
      }
      System.out.println();
    }
  }
}