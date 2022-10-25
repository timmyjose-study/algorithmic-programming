import java.util.List;
import java.util.Scanner;

public class Dfs {
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

      dfsPre(g1);
      dfsPre(g2);

      dfsPost(g1);
      dfsPost(g2);
    }
  }

  // O(|V| + |E|)
  public static void dfsPre(Graph g) {
    boolean[] visited = new boolean[g.size()];

    for (int i = 0; i < g.size(); i++) {
      dfsPre(g, visited, i);
    }
    System.out.println();
  }

  private static void dfsPre(Graph g, boolean[] visited, int currVertex) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;
    System.out.printf("%d ", currVertex);

    for (int v : g.getAdjacentVertices(currVertex)) {
      if (!visited[v]) {
        dfsPre(g, visited, v);
      }
    }
  }

  // O(|V| + |E|)
  public static void dfsPost(Graph g) {
    boolean[] visited = new boolean[g.size()];

    for (int i = 0; i < g.size(); i++) {
      dfsPost(g, visited, i);
    }
    System.out.println();
  }

  private static void dfsPost(Graph g, boolean[] visited, int currVertex) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;
    for (int v : g.getAdjacentVertices(currVertex)) {
      if (!visited[v]) {
        dfsPost(g, visited, v);
      }
    }

    System.out.printf("%d ", currVertex);
  }
}
