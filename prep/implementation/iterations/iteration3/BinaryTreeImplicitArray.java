import java.util.*;
import java.util.function.Function;

public class BinaryTreeImplicitArray {
  static class BinaryTree<T> {
    static class Node<T> {
      T data;
      Node(T data) { this.data = data; }
    }

    private List<Node<T>> arr;

    BinaryTree(int size) {
      this.arr = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        this.arr.add(null);
      }
    }

    public void build(String[] nodes, Function<String, T> parser) {
      build(0, nodes, parser);
    }

    private void build(int node, String[] nodes, Function<String, T> parser) {
      if (nodes[node].equals("null")) {
        return;
      }

      if (this.arr.get(node) == null) {
        this.arr.set(node, new Node<>(parser.apply(nodes[node])));
      }

      if (2 * node + 1 < this.arr.size()) {
        build(2 * node + 1, nodes, parser);
      }

      if (2 * node + 2 < this.arr.size()) {
        build(2 * node + 2, nodes, parser);
      }
    }

    // O(log n)
    public int height() { return height(0); }

    private int height(int node) {
      if (node >= this.arr.size() || this.arr.get(node) == null) {
        return 0;
      }

      return 1 + Math.max(height(2 * node + 1), height(2 * node + 2));
    }

    // O(n)
    public void dfsPreOrder() {
      dfsPreOrder(0);
      System.out.println();
    }

    private void dfsPreOrder(int node) {
      if (node >= this.arr.size() || this.arr.get(node) == null) {
        return;
      }

      System.out.printf("%s ", this.arr.get(node).data);
      dfsPreOrder(2 * node + 1);
      dfsPreOrder(2 * node + 2);
    }

    // O(n)
    public void dfsPreOrderIter() {
      Stack<Integer> st = new Stack<>();
      st.push(0);

      while (!st.isEmpty()) {
        int node = st.pop();

        System.out.printf("%s ", this.arr.get(node).data);

        if (2 * node + 2 < this.arr.size() &&
            this.arr.get(2 * node + 2) != null) {
          st.push(2 * node + 2);
        }

        if (2 * node + 1 < this.arr.size() &&
            this.arr.get(2 * node + 1) != null) {
          st.push(2 * node + 1);
        }
      }
      System.out.println();
    }

    // O(n)
    public void dfsInOrder() {
      dfsInOrder(0);
      System.out.println();
    }

    private void dfsInOrder(int node) {
      if (node >= this.arr.size() || this.arr.get(node) == null) {
        return;
      }

      dfsInOrder(2 * node + 1);
      System.out.printf("%s ", this.arr.get(node).data);
      dfsInOrder(2 * node + 2);
    }

    // O(n)
    public void dfsInOrderIter() {
      Stack<Integer> st = new Stack<>();
      int node = 0;

      while (node < this.arr.size() && this.arr.get(node) != null ||
             !st.isEmpty()) {
        while (node < this.arr.size() && this.arr.get(node) != null) {
          st.push(node);
          node = 2 * node + 1;
        }

        if (!st.isEmpty()) {
          node = st.pop();
          System.out.printf("%s ", this.arr.get(node).data);
          node = 2 * node + 2;
        }
      }
      System.out.println();
    }

    // O(n)
    public void dfsPostOrder() {
      dfsPostOrder(0);
      System.out.println();
    }

    private void dfsPostOrder(int node) {
      if (node >= this.arr.size() || this.arr.get(node) == null) {
        return;
      }

      dfsPostOrder(2 * node + 1);
      dfsPostOrder(2 * node + 2);
      System.out.printf("%s ", this.arr.get(node).data);
    }

    // O(n)
    public void dfsPostOrderIter() {
      Stack<Integer> st = new Stack<>();
      Stack<Integer> revSt = new Stack<>();

      st.push(0);
      while (!st.isEmpty()) {
        int node = st.pop();

        revSt.push(node);

        if (2 * node + 1 < this.arr.size() &&
            this.arr.get(2 * node + 1) != null) {
          st.push(2 * node + 1);
        }

        if (2 * node + 2 < this.arr.size() &&
            this.arr.get(2 * node + 2) != null) {
          st.push(2 * node + 2);
        }
      }

      while (!revSt.isEmpty()) {
        System.out.printf("%s ", this.arr.get(revSt.pop()).data);
      }
      System.out.println();
    }

    // O(n)
    public void bfs() {
      Queue<Integer> q = new ArrayDeque<>();
      q.add(0);

      while (!q.isEmpty()) {
        int node = q.poll();

        System.out.printf("%s ", this.arr.get(node).data);

        if (2 * node + 1 < this.arr.size() &&
            this.arr.get(2 * node + 1) != null) {
          q.add(2 * node + 1);
        }

        if (2 * node + 2 < this.arr.size() &&
            this.arr.get(2 * node + 2) != null) {
          q.add(2 * node + 2);
        }
      }
      System.out.println();
    }

    // O(n)
    public void bfsRec() {
      int h = height(0);
      for (int i = 0; i < h; i++) {
        bfsRec(0, i);
      }
      System.out.println();
    }

    private void bfsRec(int node, int level) {
      if (node >= this.arr.size() || this.arr.get(node) == null) {
        return;
      }

      if (level == 0) {
        System.out.printf("%s ", this.arr.get(node).data);
      } else {
        bfsRec(2 * node + 1, level - 1);
        bfsRec(2 * node + 2, level - 1);
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] nodes = in.nextLine().trim().split(" ");

      BinaryTree<Integer> tree = new BinaryTree<>(nodes.length);
      tree.build(nodes, Integer::parseInt);

      tree.dfsPreOrder();
      tree.dfsPreOrderIter();
      tree.dfsInOrder();
      tree.dfsInOrderIter();
      tree.dfsPostOrder();
      tree.dfsPostOrderIter();
      tree.bfs();
      tree.bfsRec();
    }
  }
}