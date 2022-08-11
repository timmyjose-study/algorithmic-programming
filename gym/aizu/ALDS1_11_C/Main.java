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

        return neighbours;
      }
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

    int size() { return this.size; }
  }

  static class DistanceInfo {
    int lastVertex;
    int distance;

    DistanceInfo() {
      this.lastVertex = -1;
      this.distance = -1;
    }
  }

  static void bfs(Graph g) {
    Map<Integer, DistanceInfo> dist = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      dist.put(i, new DistanceInfo());
    }

    dist.get(0).lastVertex = 0;
    dist.get(0).distance = 0;

    boolean[] visited = new boolean[g.size()];
    bfs(g, 0, visited, dist);

    for (int i = 0; i < g.size(); i++) {
      System.out.printf("%d %d\n", i + 1, dist.get(i).distance);
    }
  }

  static void bfs(Graph g, int currVertex, boolean[] visited,
                  Map<Integer, DistanceInfo> dist) {
    if (visited[currVertex]) {
      return;
    }

    Queue<Integer> q = new ArrayDeque<>();
    q.add(currVertex);

    while (!q.isEmpty()) {
      int v = q.poll();

      visited[v] = true;

      for (int neighbour : g.getAdjacentVertices(v)) {
        if (!visited[neighbour]) {
          int d = dist.get(neighbour).distance;

          if (d == -1) {
            dist.get(neighbour).distance = dist.get(v).distance + 1;
            dist.get(neighbour).lastVertex = v;
          }
          q.add(neighbour);
        }
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new Graph(n);

      for (int i = 0; i < n; i++) {
        int from = in.nextInt();
        int deg = in.nextInt();

        for (int j = 0; j < deg; j++) {
          int to = in.nextInt();
          g.addEdge(from - 1, to - 1);
        }
      }

      bfs(g);
    }
  }
}