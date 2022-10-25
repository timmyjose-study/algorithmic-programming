import java.util.*;

public class ConnectedComponentsDFS {
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
        throw new IllegalArgumentException("invalid vertex");
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

  static class IntWrapper {
    int id;
    int ccId;

    IntWrapper(int id, int ccId) {
      this.id = id;
      this.ccId = ccId;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();

      Graph g = new AdjacencySet(n);
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
        g.addEdge(to, from);
      }

      int nq = in.nextInt();
      while (nq-- > 0) {
        int v1 = in.nextInt();
        int v2 = in.nextInt();

        System.out.println(dfs(g, v1, v2) ? "yes" : "no");
      }
    }
  }

  private static boolean dfs(Graph g, int v1, int v2) {
    boolean[] visited = new boolean[g.size()];
    int ccId = 0;
    IntWrapper v1Id = new IntWrapper(v1, -1);
    IntWrapper v2Id = new IntWrapper(v2, -1);

    for (int i = 0; i < g.size(); i++) {
      dfs(g, visited, i, ccId, v1Id, v2Id);
      ccId++;
    }

    if (v1Id.ccId == v2Id.ccId) {
      return true;
    }
    return false;
  }

  private static void dfs(Graph g, boolean[] visited, int currVertex, int ccId,
                          IntWrapper v1Id, IntWrapper v2Id) {
    if (visited[currVertex]) {
      return;
    }

    if (currVertex == v1Id.id) {
      v1Id.ccId = ccId;
    }

    if (currVertex == v2Id.id) {
      v2Id.ccId = ccId;
    }

    visited[currVertex] = true;
    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs(g, visited, neighbour, ccId, v1Id, v2Id);
      }
    }
  }
}