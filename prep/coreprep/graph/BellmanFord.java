import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BellmanFord {
  static class DistanceInfo {
    int distance;
    int lastVertex;

    DistanceInfo(int distance, int lastVertex) {
      this.distance = distance;
      this.lastVertex = lastVertex;
    }
  }

  static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Pair)) {
        return false;
      }

      Pair other = (Pair)o;
      return this.first == other.first && this.second == other.second;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.first, this.second);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();

      Graph g1 = new AdjacencyMatrix(n, Graph.GraphType.DIRECTED);
      Graph g2 = new AdjacencySet(n, Graph.GraphType.DIRECTED);

      Map<Pair, Integer> weights = new HashMap<>();

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int w = in.nextInt();

        g1.addEdge(from, to);
        g2.addEdge(from, to);
        weights.put(new Pair(from, to), w);
      }

      bellmanFord(g1, weights);
      System.out.println();
      bellmanFord(g2, weights);
    }
  }

  // O(|E|*|V|)
  private static void bellmanFord(Graph g, Map<Pair, Integer> weights) {
    DistanceInfo[] dist = new DistanceInfo[g.size()];
    for (int i = 0; i < g.size(); i++) {
      dist[i] = new DistanceInfo(1000000, -1);
    }

    // choose 0 as the source
    dist[0].distance = 0;
    dist[0].lastVertex = 0;

    Queue<Integer> q = new ArrayDeque<>();
    Set<Pair> visited = new HashSet<>();

    // |V| - 1 iterations
    for (int i = 0; i < g.size() - 1; i++) {
      for (int j = 0; j < g.size(); j++) {
        q.add(j);
      }

      while (!q.isEmpty()) {
        int from = q.poll();

        for (int to : g.getAdjacentVertices(from)) {
          Pair edge = new Pair(from, to);

          if (visited.contains(edge)) {
            break;
          }

          visited.add(edge);

          if (dist[from].distance + weights.get(edge) < dist[to].distance) {
            dist[to].distance = dist[from].distance + weights.get(edge);
            dist[to].lastVertex = from;
          }
        }
      }

      visited.clear();
    }

    // check for negative cycle(s)
    for (int i = 0; i < g.size(); i++) {
      q.add(i);
    }

    while (!q.isEmpty()) {
      int from = q.poll();

      for (int to : g.getAdjacentVertices(from)) {
        Pair edge = new Pair(from, to);

        if (visited.contains(edge)) {
          continue;
        }

        visited.add(edge);

        if (dist[from].distance + weights.get(edge) < dist[to].distance) {
          throw new IllegalStateException("negative weight cycle detected");
        }
      }
    }

    for (int i = 0; i < g.size(); i++) {
      System.out.printf("%d\t%d\t%d\n", i, dist[i].distance,
                        dist[i].lastVertex);
    }
  }
}