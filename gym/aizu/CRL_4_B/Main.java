import java.util.*;

public class Main {
  static class Graph {
    static class Vertex {
      private Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(int v) { this.vs.add(v); }

      List<Integer> getAdjacentVertices() {
        List<Integer> neighbours = new ArrayList<>();

        for (int v : this.vs) {
          neighbours.add(v);
        }
        neighbours.sort(Integer::compare);

        return neighbours;
      }

      boolean hasEdge(int v) { return this.vs.contains(v); }
    }

    private List<Vertex> vertices;
    private int size;

    Graph(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
      }
    }

    void addEdge(int v1, int v2) {
      if (v1 < 0 || v1 >= this.size || v2 < 0 || v2 >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.vertices.get(v1).addEdge(v2);
    }

    List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    int indegree(int v) {
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

    int size() { return this.size; }
  }

  static List<Integer> topologicalSort(Graph g) {
    List<Integer> ordering = new ArrayList<>();
    Queue<Integer> q = new ArrayDeque<>();

    Map<Integer, Integer> deg = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      int indeg = g.indegree(i);
      deg.put(i, indeg);

      if (indeg == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int v = q.poll();

      ordering.add(v);

      for (int neighbour : g.getAdjacentVertices(v)) {
        int d = deg.get(neighbour);
        deg.put(neighbour, d - 1);

        if (d - 1 == 0) {
          q.add(neighbour);
        }
      }
    }

    if (ordering.size() != g.size()) {
      throw new IllegalStateException("cycle detected");
    }

    return ordering;
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

      List<Integer> ordering = topologicalSort(g);
      for (int v : ordering) {
        System.out.println(v);
      }
    }
  }
}