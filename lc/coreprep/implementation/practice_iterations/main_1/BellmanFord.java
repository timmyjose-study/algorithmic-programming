import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class BellmanFord {
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
    public int size() {
      return this.size;
    }
  }

  static class DistanceInfo {
    int distance;
    int lastVertex;

    DistanceInfo() {
      this.distance = Integer.MAX_VALUE;
      this.lastVertex = -1;
    }
  }

  record Edge(int from, int to) {}

  // O(E * V)
  public static void bellmanFord(Graph g, int source,
                                 Map<Edge, Integer> weights) {
    DistanceInfo[] dist = new DistanceInfo[g.size()];
    for (int i = 0; i < g.size(); i++) {
      dist[i] = new DistanceInfo();
    }

    dist[source].distance = 0;
    dist[source].lastVertex = source;

    Queue<Integer> q = new ArrayDeque<>();
    Set<Edge> visited = new HashSet<>();

    for (int i = 0; i < g.size() - 1; i++) {
      for (int j = 0; j < g.size(); j++) {
        q.add(j);
      }

      while (!q.isEmpty()) {
        int v = q.poll();

        if (visited.contains(v)) {
          continue;
        }

        for (int neighbour : g.getAdjacentVertices(v)) {
          Edge edge = new Edge(v, neighbour);

          if (visited.contains(edge)) {
            continue;
          }

          if (dist[v].distance + weights.get(edge) < dist[neighbour].distance) {
            dist[neighbour].distance = dist[v].distance + weights.get(edge);
            dist[neighbour].lastVertex = v;
            visited.add(edge);
          }
        }
      }

      q.clear();
      visited.clear();
    }

    for (int i = 0; i < g.size(); i++) {
      q.add(i);
    }

    while (!q.isEmpty()) {
      int v = q.poll();

      for (int neighbour : g.getAdjacentVertices(v)) {
        Edge edge = new Edge(v, neighbour);

        if (visited.contains(edge)) {
          continue;
        }

        if (dist[v].distance + weights.get(edge) < dist[neighbour].distance) {
          throw new IllegalStateException("negative weight cycle detected");
        }
      }
    }

    for (int i = 0; i < g.size(); i++) {
      if (i == source) {
        continue;
      }

      int d = dist[i].distance;
      if (d != Integer.MAX_VALUE) {
        System.out.println(d);

        int v = i;
        Stack<Integer> st = new Stack<>();

        while (v != source) {
          st.push(v);
          v = dist[v].lastVertex;
        }

        st.push(source);

        while (!st.isEmpty()) {
          System.out.printf("%d ", st.pop());
        }
        System.out.println();
      } else {
        System.out.println(-1);
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new AdjacencySet(n);

      int m = in.nextInt();
      int source = in.nextInt();
      Map<Edge, Integer> weights = new HashMap<>();

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int weight = in.nextInt();

        weights.put(new Edge(from, to), weight);
        g.addEdge(from, to);
      }

      bellmanFord(g, source, weights);
    }
  }
}