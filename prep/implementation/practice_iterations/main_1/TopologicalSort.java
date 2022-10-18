import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

      boolean hasEdge(int v) { return this.vs.contains(v); }

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

  // O(E + V) / O(V)
  public static List<Integer> topologicalSort(Graph g) {
    Queue<Integer> q = new ArrayDeque<>();

    Map<Integer, Integer> indeg = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      int id = g.indegree(i);
      if (id == 0) {
        q.add(i);
      }
      indeg.put(i, id);
    }

    List<Integer> ordering = new ArrayList<>();

    while (!q.isEmpty()) {
      int v = q.poll();

      ordering.add(v);

      for (int neighbour : g.getAdjacentVertices(v)) {
        indeg.put(neighbour, indeg.get(neighbour) - 1);

        if (indeg.get(neighbour) == 0) {
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
      Graph g = new AdjacencySet(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
      }

      var ordering = topologicalSort(g);
      for (int v : ordering) {
        System.out.printf("%d ", v);
      }
      System.out.println();
    }
  }
}