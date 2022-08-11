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
        throw new IllegalArgumentException("imvalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    int size() { return this.size; }
  }

  static class TsInfo {
    int vertex;
    int startTime;
    int endTime;

    TsInfo(int vertex, int startTime) {
      this.vertex = vertex;
      this.startTime = startTime;
    }
  }

  static class IntWrapper {
    int val;
    IntWrapper(int val) { this.val = val; }
  }

  static void dfs(Graph g) {
    boolean[] visited = new boolean[g.size()];
    IntWrapper timestamp = new IntWrapper(1);
    List<TsInfo> tsInfo = new ArrayList<>();

    for (int i = 0; i < g.size(); i++) {
      dfs(g, i, visited, timestamp, tsInfo);
    }

    tsInfo.sort((t1, t2) -> Integer.compare(t1.vertex, t2.vertex));

    for (TsInfo info : tsInfo) {
      System.out.printf("%d %d %d\n", info.vertex, info.startTime,
                        info.endTime);
    }
  }

  static void dfs(Graph g, int currVertex, boolean[] visited,
                  IntWrapper timestamp, List<TsInfo> tsInfo) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;
    TsInfo info = new TsInfo(currVertex + 1, timestamp.val);
    timestamp.val++;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs(g, neighbour, visited, timestamp, tsInfo);
      }
    }
    info.endTime = timestamp.val;
    tsInfo.add(info);
    timestamp.val++;
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

      dfs(g);
    }
  }
}