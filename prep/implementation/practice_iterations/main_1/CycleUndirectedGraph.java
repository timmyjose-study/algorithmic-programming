import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CycleUndirectedGraph {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    int size();
  }

  static class AdjacencySet implements Graph {
    static class Vertex {
      Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(int v) { this.vs.add(v); }
      List<Integer> getAdjacentVertices() {
        List<Integer> ns = new ArrayList<>();

        for (int v : this.vs) {
          ns.add(v);
        }

        return ns;
      }
    }

    private List<Vertex> vertices;
    private int size;

    AdjacencySet(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
      }
    }

    @Override
    public void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertices");
      }

      this.vertices.get(from).addEdge(to);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }
      return this.vertices.get(v).getAdjacentVertices();
    }

    @Override
    public int size() {
      return this.size;
    }
  }

  // O(E + V) / O(E = V)
  public static boolean hasCycle(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        if (dfs(g, visited, i, -1)) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean dfs(Graph g, boolean[] visited, int currVertex,
                             int parent) {
    visited[currVertex] = true;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        if (dfs(g, visited, neighbour, currVertex)) {
          return true;
        }
      } else if (parent != neighbour) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        Graph g = new AdjacencySet(n);

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
          int from = in.nextInt();
          int to = in.nextInt();

          g.addEdge(from, to);
          g.addEdge(to, from);
        }

        System.out.println(hasCycle(g));
      }
    }
  }
}