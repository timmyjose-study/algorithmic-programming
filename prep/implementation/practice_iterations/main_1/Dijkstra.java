import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

  record PQEntry(int vertex, int distance) {}

  record Edge(int from, int to) {}

  // O(ElogV) / O(E + V)
  public static void dijkstra(Graph g, int source, Map<Edge, Integer> weights) {
    DistanceInfo[] dist = new DistanceInfo[g.size()];
    for (int i = 0; i < g.size(); i++) {
      dist[i] = new DistanceInfo();
    }
    dist[source].distance = 0;
    dist[source].lastVertex = source;

    PriorityQueue<PQEntry> pq = new PriorityQueue<>(
        (p, q) -> Integer.compare(p.distance(), q.distance()));

    pq.add(new PQEntry(source, 0));

    while (!pq.isEmpty()) {
      PQEntry entry = pq.poll();
      int from = entry.vertex;
      int d = entry.distance;

      for (int neighbour : g.getAdjacentVertices(from)) {
        Edge edge = new Edge(from, neighbour);

        if (dist[from].distance + weights.get(edge) <
            dist[neighbour].distance) {
          dist[neighbour].distance = dist[from].distance + weights.get(edge);
          dist[neighbour].lastVertex = from;

          pq.add(new PQEntry(neighbour, dist[neighbour].distance));
        }
      }
    }

    for (int i = 0; i < g.size(); i++) {
      if (i == source) {
        continue;
      }

      int d = dist[i].distance;
      if (d != Integer.MAX_VALUE) {
        System.out.printf("%d\n", d);

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

      dijkstra(g, source, weights);
    }
  }
}