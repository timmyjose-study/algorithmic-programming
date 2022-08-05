import java.util.*;

public class Main {
  static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.first, this.second);
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) {
        return false;
      }

      if (!(o instanceof Pair)) {
        return false;
      }

      Pair other = (Pair)o;
      return this.first == other.first && this.second == other.second;
    }
  }

  static class DistanceInfo {
    int vertex;
    int distance;
    int lastVertex;

    DistanceInfo(int vertex, int distance, int lastVertex) {
      this.vertex = vertex;
      this.distance = distance;
      this.lastVertex = lastVertex;
    }
  }

  static class Graph {
    static class Vertex {
      int v;
      Set<Integer> vs;

      public Vertex(int v) {
        this.v = v;
        this.vs = new HashSet<>();
      }
    }

    int size;
    List<Vertex> vs;

    Graph(int n) {
      this.size = n;
      this.vs = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        this.vs.add(new Vertex(i));
      }
    }

    void addEdge(int v1, int v2) { this.vs.get(v1).vs.add(v2); }
    int size() { return this.size; }

    List<Integer> getAdjacentVertices(int v) {
      List<Integer> vs = new ArrayList<>();

      for (int vv : this.vs.get(v).vs) {
        vs.add(vv);
      }

      return vs;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();
      int source = in.nextInt();

      Graph g = new Graph(n);
      Map<Pair, Integer> weights = new HashMap<>();

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int weight = in.nextInt();

        g.addEdge(from, to);
        weights.put(new Pair(from, to), weight);
      }

      dijkstra(g, weights, source);
    }
  }

  private static void dijkstra(Graph g, Map<Pair, Integer> weights,
                               int source) {
    DistanceInfo[] dist = new DistanceInfo[g.size()];
    for (int i = 0; i < g.size(); i++) {
      dist[i] = new DistanceInfo(i, Integer.MAX_VALUE, -1);
    }
    dist[source].distance = 0;
    dist[source].lastVertex = source;

    PriorityQueue<Pair> pq = new PriorityQueue<>(
        (p, q) -> { return Integer.compare(q.second, p.second); });

    pq.add(new Pair(source, dist[source].distance));

    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      int from = p.first;
      int currDist = p.second;

      for (int to : g.getAdjacentVertices(from)) {
        Pair edge = new Pair(from, to);
        if (currDist + weights.get(edge) < dist[to].distance) {
          dist[to].distance = currDist + weights.get(edge);
          dist[to].lastVertex = from;
          pq.add(new Pair(to, dist[to].distance));
        }
      }
    }

    for (int i = 0; i < g.size(); i++) {
      int d = dist[i].distance;

      if (d == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(d);
      }
    }
  }
}