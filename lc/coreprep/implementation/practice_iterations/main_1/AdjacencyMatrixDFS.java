import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AdjacencyMatrixBFS {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    int size();
  }

  static class AdjacencyMatrix implements Graph {
    private int[][] adj;

    private int size;

    AdjacencyMatrix(int size) {
      this.size = size;
      this.adj = new int[size][size];
    }

    @Override
    public void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertices");
      }

      this.adj[from][to] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      List<Integer> ns = new ArrayList<>();
      for (int i = 0; i < this.size; i++) {
        if (this.adj[v][i] == 1) {
          ns.add(i);
        }
      }

      return ns;
    }

    @Override
    public int size() {
      return this.size;
    }
  }

  // O(E + V) / O(V)
  public static void bfs(Graph g) {}

  // O(E + V) / O(V)
  public static void bfsRec(Graph g) {}

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new AdjacencyMatrix(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
        g.addEdge(to, from);
      }

      bfs(g);
      bfsRec(g);
    }
  }
}