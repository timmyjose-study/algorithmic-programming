import java.util.*;
import java.util.function.Function;

public class BinaryTreeImplicitArray {
  @SuppressWarnings({"unchecked", "rawtypes"})
  static class BinaryTree<T> {
    static class Node<T> {
      T data;
      Node(T data) { this.data = data; }
    }

    private Node<T>[] arr;

    public BinaryTree(int size) { this.arr = new Node[size]; }

    public void build(String[] nodes, Function<String, T> parser) {
      buildRecursively(0, nodes, parser);
    }

    private void buildRecursively(int root, String[] nodes,
                                  Function<String, T> parser) {
      if (root >= this.arr.length || nodes[root].equals("null")) {
        return;
      }

      if (this.arr[root] == null) {
        this.arr[root] = new Node<>(parser.apply(nodes[root]));
      }

      buildRecursively(2 * root + 1, nodes, parser);
      buildRecursively(2 * root + 2, nodes, parser);
    }

    public void dfsPreOrder() {
      dfsPreOrder(0);
      System.out.println();
    }

    private void dfsPreOrder(int root) {
      if (root >= this.arr.length || this.arr[root] == null) {
        return;
      }

      System.out.printf("%s ", this.arr[root].data);
      dfsPreOrder(2 * root + 1);
      dfsPreOrder(2 * root + 2);
    }

    public void dfsPreOrderIter() {
      Stack<Integer> st = new Stack<>();
      st.push(0);

      while (!st.isEmpty()) {
        int root = st.pop();

        System.out.printf("%s ", this.arr[root].data);

        if (2 * root + 2 < this.arr.length && this.arr[2 * root + 2] != null) {
          st.push(2 * root + 2);
        }

        if (2 * root + 1 < this.arr.length && this.arr[2 * root + 1] != null) {
          st.push(2 * root + 1);
        }
      }
      System.out.println();
    }

    public void dfsInOrder() {
      dfsInOrder(0);
      System.out.println();
    }

    private void dfsInOrder(int root) {
      if (root >= this.arr.length || this.arr[root] == null) {
        return;
      }

      dfsInOrder(2 * root + 1);
      System.out.printf("%s ", this.arr[root].data);
      dfsInOrder(2 * root + 2);
    }

    public void dfsInOrderIter() {
      Stack<Integer> st = new Stack<>();
      int currNode = 0;

      while (currNode < this.arr.length && this.arr[currNode] != null ||
             !st.isEmpty()) {
        while (currNode < this.arr.length && this.arr[currNode] != null) {
          st.push(currNode);
          currNode = 2 * currNode + 1;
        }

        if (!st.isEmpty()) {
          currNode = st.pop();
          System.out.printf("%s ", this.arr[currNode].data);
          currNode = 2 * currNode + 2;
        }
      }
      System.out.println();
    }

    public void dfsPostOrder() {
      dfsPostOrder(0);
      System.out.println();
    }

    private void dfsPostOrder(int root) {
      if (root >= this.arr.length || this.arr[root] == null) {
        return;
      }

      dfsPostOrder(2 * root + 1);
      dfsPostOrder(2 * root + 2);
      System.out.printf("%s ", this.arr[root].data);
    }

    public void dfsPostOrderIter() {
      Stack<Integer> st = new Stack<>();
      Stack<Integer> revSt = new Stack<>();
      st.push(0);

      while (!st.isEmpty()) {
        int node = st.pop();

        revSt.push(node);

        if (2 * node + 1 < this.arr.length && this.arr[2 * node + 1] != null) {
          st.push(2 * node + 1);
        }

        if (2 * node + 2 < this.arr.length && this.arr[2 * node + 2] != null) {
          st.push(2 * node + 2);
        }
      }

      while (!revSt.isEmpty()) {
        System.out.printf("%s ", this.arr[revSt.pop()].data);
      }
      System.out.println();
    }

    public void bfs() {
      Queue<Integer> q = new ArrayDeque<>();
      q.add(0);

      while (!q.isEmpty()) {
        int node = q.poll();
        System.out.printf("%s ", this.arr[node].data);

        if (2 * node + 1 < this.arr.length && this.arr[2 * node + 1] != null) {
          q.add(2 * node + 1);
        }

        if (2 * node + 2 < this.arr.length && this.arr[2 * node + 2] != null) {
          q.add(2 * node + 2);
        }
      }
      System.out.println();
    }

    public int height() { return height(0); }

    private int height(int root) {
      if (root >= this.arr.length || this.arr[root] == null) {
        return 0;
      }
      return 1 + Math.max(height(2 * root + 1), height(2 * root + 2));
    }

    public void bfsRec() {
      int h = height();
      for (int i = 0; i < h; i++) {
        bfsRec(0, i);
      }
      System.out.println();
    }

    private void bfsRec(int root, int level) {
      if (root >= this.arr.length || this.arr[root] == null) {
        return;
      }

      if (level == 0) {
        System.out.printf("%s ", this.arr[root].data);
      } else {
        bfsRec(2 * root + 1, level - 1);
        bfsRec(2 * root + 2, level - 1);
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