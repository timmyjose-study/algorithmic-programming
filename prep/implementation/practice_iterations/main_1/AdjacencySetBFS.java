import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AdjacencySetBFS {
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

  // O(E + V) / O(V)
  public static void bfs(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        bfs(g, visited, i);
      }
    }
    System.out.println();
  }

  private static void bfs(Graph g, boolean[] visited, int currVertex) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(currVertex);

    while (!q.isEmpty()) {
      int v = q.poll();

      if (visited[v]) {
        continue;
      }

      visited[v] = true;
      System.out.printf("%d ", v);

      for (int neighbour : g.getAdjacenctVertices(v)) {
        q.add(neighbour);
      }
    }
  }

  // O(E + V) / O(V)
  public static void bfsRec(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        bfsRec(g, visited, i);
      }
    }
    System.out.println();
  }

  private static void bfsRec(Graph g, boolean[] visited, int currVertex) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(currVertex);

    bfsRec(g, visited, q);
  }

  private static void bfsRec(Graph g, boolean[] visited, Queue<Integer> q) {
    if (q.isEmpty()) {
      return;
    }

    int v = q.poll();

    if (visited[v]) {
      return;
    }

    visited[v] = true;
    System.out.printf("%d ", v);

    for (int neighbour : g.getAdjacenctVertices(v)) {
      q.add(neighbour);
    }

    bfsRec(g, visited, q);
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

      bfs(g);
      bfsRec(g);
    }
  }
}