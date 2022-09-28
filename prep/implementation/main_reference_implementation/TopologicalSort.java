import java.util.*;

public class TopologicalSort {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    int indegree(int v);
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

      boolean hasEdge(int v) { return this.vs.contains(v); }
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
    public int indegree(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      int indeg = 0;
      for (int i = 0; i < this.size; i++) {
        if (this.vertices.get(i).hasEdge(v)) {
          indeg++;
        }
      }

      return indeg;
    }

    @Override
    public int size() {
      return this.size;
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
      }

      topologicalSort(g);
    }
  }

  // O(|V| + |E|)
  private static void topologicalSort(Graph g) {
    Queue<Integer> q = new ArrayDeque<>();
    List<Integer> sorted = new ArrayList<>();

    Map<Integer, Integer> deg = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      int d = g.indegree(i);
      deg.put(i, d);

      if (d == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int v = q.poll();
      sorted.add(v);

      for (int neighbour : g.getAdjacentVertices(v)) {
        deg.put(neighbour, deg.get(neighbour) - 1);
        if (deg.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    if (sorted.size() != g.size()) {
      throw new IllegalStateException("cycle detected - not a DAG");
    }

    for (int v : sorted) {
      System.out.printf("%d ", v);
    }
    System.out.println();
  }
}