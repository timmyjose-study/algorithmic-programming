import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathUnweighted {
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
      int destination = in.nextInt();

      Graph g1 = new AdjacencyMatrix(n);
      Graph g2 = new AdjacencySet(n);

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g1.addEdge(from, to);
        g2.addEdge(from, to);
      }

      shortestPath(g1, source, destination);
      shortestPath(g2, source, destination);
    }
  }

  // O(|V|+|E|)
  public static void shortestPath(Graph g, int source, int destination) {
    Map<Integer, DistanceInfo> dist =
        buildDistanceTable(g, source, destination);

    if (dist.get(destination).distance == -1) {
      System.out.printf("No path exists from %d to %d\n", source, destination);
    } else {
      System.out.printf("Shortest path distance from %d to %d = %d\n", source,
                        destination, dist.get(destination).distance);

      Stack<Integer> st = new Stack<>();
      int prevVertex = -1, currVertex = destination;

      st.push(currVertex);
      while (prevVertex != source) {
        prevVertex = dist.get(currVertex).lastVertex;
        st.push(prevVertex);
        currVertex = prevVertex;
      }

      while (!st.empty()) {
        System.out.printf("%d ", st.pop());
      }
      System.out.println();
    }
  }

  private static Map<Integer, DistanceInfo>
  buildDistanceTable(Graph g, int source, int destination) {
    Map<Integer, DistanceInfo> dist = new HashMap<>();

    for (int i = 0; i < g.size(); i++) {
      dist.put(i, new DistanceInfo());
    }

    // initialise distance table with source
    dist.get(source).distance = 0;
    dist.get(source).lastVertex = source;

    boolean[] visited = new boolean[g.size()];
    Queue<Integer> q = new ArrayDeque<>();

    q.add(source);
    while (!q.isEmpty()) {
      int v = q.poll();

      if (visited[v]) {
        continue;
      }

      visited[v] = true;
      for (int vv : g.getAdjacentVertices(v)) {
        if (!visited[vv]) {
          if (dist.get(vv).distance == -1) {
            dist.get(vv).distance = dist.get(v).distance + 1;
            dist.get(vv).lastVertex = v;
            q.add(vv);
          }
        }
      }
    }

    return dist;
  }
}