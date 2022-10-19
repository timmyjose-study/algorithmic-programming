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

      void addEdge(int v) { this.vs.add(v); }

      List<Integer> getAdjacentVertices() { return new ArrayList<>(this.vs); }

      boolean hasEdge(int v) { return this.vs.contains(v); }
    }

    private List<Vertex> vertices;

    AdjacencySet(int size) {
      this.vertices = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
      }
    }

    @Override
    public void addEdge(int from, int to) {
      if (from < 0 || from >= size() || to < 0 || to >= size()) {
        throw new IllegalArgumentException("invalid vertices");
      }

      this.vertices.get(from).addEdge(to);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= size()) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    @Override
    public int indegree(int v) {
      if (v < 0 || v >= size()) {
        throw new IllegalArgumentException("invalid vertex");
      }

      int indeg = 0;
      for (int i = 0; i < size(); i++) {
        if (this.vertices.get(i).hasEdge(v)) {
          indeg++;
        }
      }

      return indeg;
    }

    @Override
    public int size() {
      return this.vertices.size();
    }
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
        }

        var ordering = sort(g);
        for (int o : ordering) {
          System.out.printf("%d ", o);
        }
        System.out.println();
      }
    }
  }

  // O(V + E) / O(V + E)
  public static List<Integer> sort(Graph g) {
    Queue<Integer> q = new ArrayDeque<>();

    Map<Integer, Integer> indegree = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      int d = g.indegree(i);
      indegree.put(i, d);

      if (d == 0) {
        q.add(i);
      }
    }

    List<Integer> ordering = new ArrayList<>();
    while (!q.isEmpty()) {
      int v = q.poll();

      ordering.add(v);

      for (int neighbour : g.getAdjacentVertices(v)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);
        if (indegree.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    if (ordering.size() != g.size()) {
      throw new IllegalStateException("cycle detected");
    }

    return ordering;
  }
}