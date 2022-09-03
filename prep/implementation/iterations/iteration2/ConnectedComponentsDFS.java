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
    int val;
    int ccId;

    IntWrapper(int val) { this.val = val; }
  }

  public static void connectedComponents(Graph g, int v1, int v2) {
    boolean[] visited = new boolean[g.size()];
    IntWrapper v1ccId = new IntWrapper(v1);
    IntWrapper v2ccId = new IntWrapper(v2);
    int ccId = 0;

    for (int i = 0; i < g.size(); i++) {
      dfs(g, visited, v1ccId, v2ccId, ccId, i);
      ccId++;
    }

    if (v1ccId.ccId == v2ccId.ccId) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
  }

  private static void dfs(Graph g, boolean[] visited, IntWrapper v1ccId,
                          IntWrapper v2ccId, int ccId, int currVertex) {
    if (visited[currVertex]) {
      return;
    }

    if (currVertex == v1ccId.val) {
      v1ccId.ccId = ccId;
    }

    if (currVertex == v2ccId.val) {
      v2ccId.ccId = ccId;
    }

    visited[currVertex] = true;
    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      dfs(g, visited, v1ccId, v2ccId, ccId, neighbour);
    }
  }
}