import java.util.*;

public class Dijkstra {
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
      int m = in.nextInt();
      int source = in.nextInt();

      Graph g = new AdjacencySet(n);
      Map<Pair, Integer> weights = new HashMap<>();

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int w = in.nextInt();

        g.addEdge(from, to);
        weights.put(new Pair(from, to), w);
      }

      dijkstra(g, weights, source);
    }
  }
}