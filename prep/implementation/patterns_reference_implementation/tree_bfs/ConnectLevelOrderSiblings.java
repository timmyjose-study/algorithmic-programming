import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
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

  private static void connectLevelOrderSiblings(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      TreeNode prev = null;
      int levelSize = q.size();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = q.poll();

        if (prev != null) {
          prev.next = node;
        }
        prev = node;

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
    }
  }

  private static void printLevelOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
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

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String[] nodes = in.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes);
        connectLevelOrderSiblings(root);
        printLevelOrder(root);
      }
    }
  }
}