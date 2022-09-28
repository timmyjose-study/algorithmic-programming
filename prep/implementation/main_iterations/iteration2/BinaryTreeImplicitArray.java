import java.util.*;
import java.util.function.Function;

public class BinaryTreeImplicitArray {
  @SuppressWarnings({"rawtypes", "unchecked"})
  static class BinaryTree<T extends Comparable<T>> {
    static class Node<T> {
      T data;
      Node(T data) { this.data = data; }
    }

    private Node<T>[] arr;
    private int size;

    BinaryTree(int size) {
      this.size = size;
      this.arr = (Node<T>[]) new Node[size];
    }

    public void build(String[] nodes, Function<String, T> parser) {
      build(0, nodes, parser);
    }

    private void build(int node, String[] nodes, Function<String, T> parser) {
      if (node >= nodes.length || nodes[node].equals("null")) {
        return;
      }

      if (this.arr[node] == null) {
        this.arr[node] = new Node<>(parser.apply(nodes[node]));
      }

      build(2 * node + 1, nodes, parser);
      build(2 * node + 2, nodes, parser);
    }

    public void dfsPreOrder() {
      dfsPreOrder(0);
      System.out.println();
    }

    private void dfsPreOrder(int node) {
      if (this.arr[node] == null) {
        return;
      }

      System.out.printf("%s ", this.arr[node].data);

      if (2 * node + 1 < this.size) {
        dfsPreOrder(2 * node + 1);
      }

      if (2 * node + 2 < this.size) {
        dfsPreOrder(2 * node + 2);
      }
    }

    public void dfsPreOrderIter() {
      Stack<Integer> st = new Stack<>();
      st.push(0);

      while (!st.isEmpty()) {
        int node = st.pop();

        System.out.printf("%s ", this.arr[node].data);
        if (2 * node + 2 < this.size && this.arr[2 * node + 2] != null) {
          st.push(2 * node + 2);
        }

        if (2 * node + 1 < this.size && this.arr[2 * node + 1] != null) {
          st.push(2 * node + 1);
        }
      }
      System.out.println();
    }

    public void dfsInOrder() {
      dfsInOrder(0);
      System.out.println();
    }

    private void dfsInOrder(int node) {
      if (this.arr[node] == null) {
        return;
      }

      if (2 * node + 1 < this.size) {
        dfsInOrder(2 * node + 1);
      }
      System.out.printf("%s ", this.arr[node].data);

      if (2 * node + 2 < this.size) {
        dfsInOrder(2 * node + 2);
      }
    }

    public void dfsInOrderIter() {
      Stack<Integer> st = new Stack<>();
      int currNode = 0;

      while (currNode < this.size && this.arr[currNode] != null ||
             !st.isEmpty()) {
        while (currNode < this.size && this.arr[currNode] != null) {
          st.push(currNode);
          currNode = 2 * currNode + 1;
        }

        if (!st.isEmpty()) {
          int node = st.pop();
          System.out.printf("%s ", this.arr[node].data);
          if (2 * node + 2 < this.size) {
            currNode = 2 * node + 2;
          }
        }
      }
      System.out.println();
    }

    public void dfsPostOrder() {
      dfsPostOrder(0);
      System.out.println();
    }

    private void dfsPostOrder(int node) {
      if (this.arr[node] == null) {
        return;
      }

      if (2 * node + 1 < this.size) {
        dfsPostOrder(2 * node + 1);
      }

      if (2 * node + 2 < this.size) {
        dfsPostOrder(2 * node + 2);
      }

      System.out.printf("%s ", this.arr[node].data);
    }

    public void dfsPostOrderIter() {
      Stack<Integer> st = new Stack<>();
      Stack<Integer> revSt = new Stack<>();

      st.push(0);
      while (!st.isEmpty()) {
        int node = st.pop();

        revSt.push(node);

        if (2 * node + 1 < this.size && this.arr[2 * node + 1] != null) {
          st.push(2 * node + 1);
        }

        if (2 * node + 2 < this.size && this.arr[2 * node + 2] != null) {
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

        if (2 * node + 1 < this.size && this.arr[2 * node + 1] != null) {
          q.add(2 * node + 1);
        }

        if (2 * node + 2 < this.size && this.arr[2 * node + 2] != null) {
          q.add(2 * node + 2);
        }
      }
      System.out.println();
    }

    public int height() { return height(0); }

    private int height(int node) {
      if (node > this.size || this.arr[node] == null) {
        return 0;
      }

      return 1 + Math.max(height(2 * node + 1), height(2 * node + 2));
    }

    public void bfsRec() {
      int h = height();
      for (int i = 0; i < h; i++) {
        bfsRec(0, i);
      }
      System.out.println();
    }

    private void bfsRec(int node, int level) {
      if (this.arr[node] == null) {
        return;
      }

      if (level == 0) {
        System.out.printf("%s ", this.arr[node].data);
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