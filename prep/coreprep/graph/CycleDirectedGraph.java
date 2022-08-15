import java.util.*;

public class CycleDirectedGraph {
  static class Graph {
    static class Vertex {
      Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(int v) { this.vs.add(v); }
      List<Integer> getAdjacentVertices() {
        List<Integer> ns = new ArrayList<>(this.vs.size());
        for (int v : this.vs) {
          ns.add(v);
        }

        ns.sort((v1, v2) -> Integer.compare(v1, v2));

        return ns;
      }
    }

    private int size;
    private List<Vertex> vertices;

    Graph(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
      }
    }

    void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.vertices.get(from).addEdge(to);
    }

    List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    int size() { return this.size; }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new Graph(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
      }

      System.out.println(hasCycle(g));
    }
  }

  // O(|V| + |E|)
  private static boolean hasCycle(Graph g) {
    boolean[] visited = new boolean[g.size()];
    boolean[] recStack = new boolean[g.size()];

    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        if (dfs(g, i, visited, recStack)) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean dfs(Graph g, int currVertex, boolean[] visited,
                             boolean[] recStack) {
    if (recStack[currVertex]) {
      return true;
    }

    visited[currVertex] = true;
    recStack[currVertex] = true;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (dfs(g, neighbour, visited, recStack)) {
        return true;
      }
    }

    // mark current vertex as not part of the new call stack
    recStack[currVertex] = false;

    return false;
  }
}