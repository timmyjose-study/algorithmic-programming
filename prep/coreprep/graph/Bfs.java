import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();

      Graph g1 = new AdjacencyMatrix(n);
      Graph g2 = new AdjacencySet(n);

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g1.addEdge(from, to);
        g2.addEdge(from, to);
      }

      bfs(g1);
      bfs(g2);
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
    Queue<Integer> q = new ArrayDeque<>();
    q.add(currVertex);

    while (!q.isEmpty()) {
      int v = q.poll();

      if (visited[v]) {
        continue;
      }

      visited[v] = true;
      System.out.printf("%d ", v);

      for (int vv : g.getAdjacentVertices(v)) {
        if (!visited[vv]) {
          q.add(vv);
        }
      }
    }
  }
}