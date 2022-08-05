import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
  static class DistanceInfo {
    int distance;
    int lastVertex;

    DistanceInfo(int distance, int lastVertex) {
      this.distance = distance;
      this.lastVertex = lastVertex;
    }
  }

  static class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.first, this.second);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
      if (o == null) {
        return false;
      }

      Pair<T, U> other = (Pair<T, U>)o;
      return this.first.equals(other.first) && this.second.equals(other.second);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();
      int source = in.nextInt();

      Graph g1 = new AdjacencyMatrix(n, Graph.GraphType.DIRECTED);
      Graph g2 = new AdjacencySet(n, Graph.GraphType.DIRECTED);

      Map<Pair<Integer, Integer>, Integer> weights = new HashMap<>();

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int w = in.nextInt();

        g1.addEdge(from, to);
        g2.addEdge(from, to);
        weights.put(new Pair<>(from, to), w);
      }

      dijkstra(g1, weights, source);
      System.out.println();
      dijkstra(g2, weights, source);
    }
  }

  // O(|E|log|V|)
  private static void
  dijkstra(Graph g, Map<Pair<Integer, Integer>, Integer> weights, int source) {
    DistanceInfo[] dist = new DistanceInfo[g.size()];
    for (int i = 0; i < g.size(); i++) {
      dist[i] = new DistanceInfo(Integer.MAX_VALUE, -1);
    }
    dist[source].distance = 0;
    dist[source].lastVertex = source;

    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
        (p, q) -> { return Integer.compare(q.second, p.second); });
    pq.add(new Pair<>(source, 0));

    while (!pq.isEmpty()) {
      Pair<Integer, Integer> p = pq.poll();
      int from = p.first;
      int currDist = p.second;

      for (int to : g.getAdjacentVertices(from)) {
        Pair<Integer, Integer> edge = new Pair<>(from, to);
        if (currDist + weights.get(edge) < dist[to].distance) {
          dist[to].distance = currDist + weights.get(edge);
          dist[to].lastVertex = from;
          pq.add(new Pair<>(to, dist[to].distance));
        }
      }
    }

    for (int i = 0; i < g.size(); i++) {
      System.out.printf("%d\t%d\t%s\n", i, dist[i].distance,
                        dist[i].lastVertex);
    }
  }
}