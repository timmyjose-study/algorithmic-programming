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

        ns.sort(Integer::compare);
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

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new AdjacencySet(n);

      int m = in.nextInt();
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

        connectedComponents(g, v1, v2);
      }
    }
  }

  static class IntWrapper {
    int ival;
    int ccId;

    IntWrapper(int ival) { this.ival = ival; }
  }

  public static void connectedComponents(Graph g, int v1, int v2) {
    boolean[] visited = new boolean[g.size()];
    int ccId = 0;
    IntWrapper v1Id = new IntWrapper(v1);
    IntWrapper v2Id = new IntWrapper(v2);

    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfs(g, visited, i, v1, v2, ccId, v1Id, v2Id);
      }
      ccId++;
    }

    if (v1Id.ccId == v2Id.ccId) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
  }

  private static void dfs(Graph g, boolean[] visited, int currVertex, int v1,
                          int v2, int ccId, IntWrapper v1Id, IntWrapper v2Id) {
    visited[currVertex] = true;

    if (currVertex == v1) {
      v1Id.ccId = ccId;
    }

    if (currVertex == v2) {
      v2Id.ccId = ccId;
    }

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs(g, visited, neighbour, v1, v2, ccId, v1Id, v2Id);
      }
    }
  }
}