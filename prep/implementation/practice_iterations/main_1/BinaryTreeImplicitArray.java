import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class BinaryTreeImplicitArray {
  static class BinaryTree {
    static class TreeNode {
      int val;

      TreeNode(int val) { this.val = val; }
    }

    private List<TreeNode> arr;
    private int size;

    public BinaryTree(String[] nodes) {
      this.size = nodes.length;

      this.arr = new ArrayList<>(this.size);
      for (int i = 0; i < size; i++) {
        this.arr.add(null);
      }

      buildTree(nodes, 0);
    }

    private void buildTree(String[] nodes, int currIdx) {
      if (currIdx >= this.size || nodes[currIdx].equalsIgnoreCase("null")) {
        return;
      } else {
        this.arr.set(currIdx, new TreeNode(Integer.parseInt(nodes[currIdx])));
        buildTree(nodes, 2 * currIdx + 1);
        buildTree(nodes, 2 * currIdx + 2);
      }
    }

    // O(n) / O(n)
    public void dfsPre() {
      if (this.arr.get(0) == null) {
        return;
      }

      dfsPre(0);
      System.out.println();
    }

    private void dfsPre(int node) {
      if (node >= this.size || this.arr.get(node) == null) {
        return;
      }

      System.out.printf("%d ", this.arr.get(node).val);
      dfsPre(2 * node + 1);
      dfsPre(2 * node + 2);
    }

    // O(n) / O(n)
    public void dfsPreIter() {
      Stack<Integer> st = new Stack<>();
      st.push(0);

      while (!st.isEmpty()) {
        int node = st.pop();

        System.out.printf("%d ", this.arr.get(node).val);

        if (2 * node + 2 < this.size && this.arr.get(2 * node + 2) != null) {
          st.push(2 * node + 2);
        }

        if (2 * node + 1 < this.size && this.arr.get(2 * node + 1) != null) {
          st.push(2 * node + 1);
        }
      }

      System.out.println();
    }

    // O(n) / O(n)
    public void dfsIn() {
      if (this.arr.get(0) == null) {
        return;
      }

      dfsIn(0);
      System.out.println();
    }

    private void dfsIn(int node) {
      if (node >= this.size || this.arr.get(node) == null) {
        return;
      }

      dfsIn(2 * node + 1);
      System.out.printf("%d ", this.arr.get(node).val);
      dfsIn(2 * node + 2);
    }

    // O(n) / O(n)
    public void dfsInIter() {
      if (this.arr.get(0) == null) {
        return;
      }

      Stack<Integer> st = new Stack<>();
      int currNode = 0;

      while ((currNode < this.size && this.arr.get(currNode) != null) ||
             !st.isEmpty()) {
        while (currNode < this.size && this.arr.get(currNode) != null) {
          st.push(currNode);
          currNode = 2 * currNode + 1;
        }

        if (!st.isEmpty()) {
          currNode = st.pop();
          System.out.printf("%d ", this.arr.get(currNode).val);
          currNode = 2 * currNode + 2;
        }
      }
      System.out.println();
    }

    // O(n) / O(n)
    public void dfsPost() {
      if (this.arr.get(0) == null) {
        return;
      }

      dfsPost(0);
      System.out.println();
    }

    private void dfsPost(int node) {
      if (node >= this.size || this.arr.get(node) == null) {
        return;
      }

      dfsPost(2 * node + 1);
      dfsPost(2 * node + 2);
      System.out.printf("%d ", this.arr.get(node).val);
    }

    public void dfsPostIter() {
      if (this.arr.get(0) == null) {
        return;
      }

      Stack<Integer> st = new Stack<>();
      Stack<Integer> revSt = new Stack<>();

      st.push(0);

      while (!st.isEmpty()) {
        int node = st.pop();
        revSt.push(node);

        if (2 * node + 1 < this.size && this.arr.get(2 * node + 1) != null) {
          st.push(2 * node + 1);
        }

        if (2 * node + 2 < this.size && this.arr.get(2 * node + 2) != null) {
          st.push(2 * node + 2);
        }
      }

      while (!revSt.isEmpty()) {
        System.out.printf("%d ", this.arr.get(revSt.pop()).val);
      }
      System.out.println();
    }

    // O(n) / O(n)
    public void bfs() {
      if (this.arr.get(0) == null) {
        return;
      }

      Queue<Integer> q = new ArrayDeque<>();
      q.add(0);

      while (!q.isEmpty()) {
        int node = q.poll();

        System.out.printf("%d ", this.arr.get(node).val);

        if (2 * node + 1 < this.size && this.arr.get(2 * node + 1) != null) {
          q.add(2 * node + 1);
        }

        if (2 * node + 2 < this.size && this.arr.get(2 * node + 2) != null) {
          q.add(2 * node + 2);
        }
      }

      System.out.println();
    }

    // O(n) / O(n)
    public void bfsRec() {
      if (this.arr.get(0) == null) {
        return;
      }

      Queue<Integer> q = new ArrayDeque<>();
      q.add(0);

      bfsRec(q);
      System.out.println();
    }

    private void bfsRec(Queue<Integer> q) {
      if (q.isEmpty()) {
        return;
      }

      int node = q.poll();
      System.out.printf("%d ", this.arr.get(node).val);

      if (2 * node + 1 < this.size && this.arr.get(2 * node + 1) != null) {
        q.add(2 * node + 1);
      }

      if (2 * node + 2 < this.size && this.arr.get(2 * node + 2) != null) {
        q.add(2 * node + 2);
      }

      bfsRec(q);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] nodes = in.nextLine().trim().split(" ");

      BinaryTree tree = new BinaryTree(nodes);
      tree.dfsPre();
      tree.dfsPreIter();

      tree.dfsIn();
      tree.dfsInIter();

      tree.dfsPost();
      tree.dfsPostIter();

      tree.bfs();
      tree.bfsRec();
    }
  }
}