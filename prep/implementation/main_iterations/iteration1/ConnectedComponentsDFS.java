import java.util.*;

public class ConnectedComponentsDFS {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacenctVertices(int v);
    int size();
  }

  static class AdjacencySet implements Graph {
    static class Vertex {
      Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(int v) { this.vs.add(v); }

      List<Integer> getAdjacenctVertices() {
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
    public List<Integer> getAdjacenctVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }
      return this.vertices.get(v).getAdjacenctVertices();
    }

    @Override
    public int size() {
      return this.size;
    }
  }

  static class IntWrapper { int val; }

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

  // O(|V| + |E|)
  private static void connectedComponents(Graph g, int v1, int v2) {
    IntWrapper v1Id = new IntWrapper();
    IntWrapper v2Id = new IntWrapper();

    boolean[] visited = new boolean[g.size()];
    int ccId = 0;
    for (int i = 0; i < g.size(); i++) {
      dfs(g, visited, ccId, v1, v2, v1Id, v2Id, i);
      ccId++;
    }

    System.out.println(v1Id.val == v2Id.val ? "yes" : "no");
  }

  private static void dfs(Graph g, boolean[] visited, int ccId, int v1, int v2,
                          IntWrapper v1Id, IntWrapper v2Id, int currVertex) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;

    if (currVertex == v1) {
      v1Id.val = ccId;
    }

    if (currVertex == v2) {
      v2Id.val = ccId;
    }

    for (int neighbour : g.getAdjacenctVertices(currVertex)) {
      dfs(g, visited, ccId, v1, v2, v1Id, v2Id, neighbour);
    }
  }
}