import java.util.*;

public class AdjacencyMatrixBFS {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    int size();
  }

  static class AdjacencyMatrix implements Graph {
    private int[][] adj;
    private int size;

    AdjacencyMatrix(int size) {
      this.size = size;
      this.adj = new int[size][size];
    }

    @Override
    public void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.adj[from][to] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex " + v);
      }

      List<Integer> ns = new ArrayList<>();
      for (int i = 0; i < this.size; i++) {
        if (this.adj[v][i] == 1) {
          ns.add(i);
        }
      }

      return ns;
    }

    @Override
    public int size() {
      return this.size;
    }
  }

  public static void bfs(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      bfs(g, visited, i);
    }
    System.out.println();
  }

  private static void bfs(Graph g, boolean[] visited, int currVertex) {
    if (visited[currVertex]) {
      return;
    }

    Queue<Integer> q = new ArrayDeque<>();
    q.add(currVertex);

    while (!q.isEmpty()) {
      int v = q.poll();

      if (visited[v]) {
        continue;
      }

      visited[v] = true;

      System.out.printf("%d ", v);
      for (int neighbour : g.getAdjacentVertices(v)) {
        if (!visited[neighbour]) {
          q.add(neighbour);
        }
      }
    }
  }

  public static void bfsRec(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      bfsRec(g, visited, i);
    }
    System.out.println();
  }

  private static void bfsRec(Graph g, boolean[] visited, int currVertex) {
    if (visited[currVertex]) {
      return;
    }

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

    for (int neighbour : g.getAdjacentVertices(v)) {
      if (!visited[neighbour]) {
        q.add(neighbour);
      }
    }

    bfsRec(g, visited, q);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();

      Graph g = new AdjacencyMatrix(n);
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