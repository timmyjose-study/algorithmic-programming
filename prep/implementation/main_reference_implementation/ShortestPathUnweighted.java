import java.util.*;

public class ShortestPathUnweighted {
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

  static class DistanceInfo {
    int distance;
    int lastVertex;

    DistanceInfo() {
      this.distance = -1;
      this.lastVertex = -1;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();
      int source = in.nextInt();

      Graph g = new AdjacencySet(n);
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
        g.addEdge(to, from);
      }

      shortestPath(g, source);
    }
  }

  // O(|V| + |E|) / O(|V|)
  private static void shortestPath(Graph g, int source) {
    Map<Integer, DistanceInfo> dist = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      dist.put(i, new DistanceInfo());
    }

    dist.get(source).distance = 0;
    dist.get(source).lastVertex = source;

    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      bfs(g, visited, i, dist);
    }

    for (int i = 0; i < g.size(); i++) {
      if (i == source) {
        continue;
      }
      int d = dist.get(i).distance;
      System.out.printf("%d\n", d);
      if (d == -1) {
        System.out.println("No path");
      } else {
        Stack<Integer> st = new Stack<>();
        int v = i;
        while (v != source) {
          st.push(v);
          v = dist.get(v).lastVertex;
        }
        st.push(v);

        while (!st.empty()) {
          System.out.printf("%d ", st.pop());
        }
        System.out.println();
      }
    }
  }

  private static void bfs(Graph g, boolean[] visited, int currVertex,
                          Map<Integer, DistanceInfo> dist) {
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
      for (int neighbour : g.getAdjacentVertices(v)) {
        if (!visited[neighbour]) {
          if (dist.get(neighbour).distance == -1) {
            dist.get(neighbour).distance = dist.get(v).distance + 1;
            dist.get(neighbour).lastVertex = v;
          }
          q.add(neighbour);
        }
      }
    }
  }
}