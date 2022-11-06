import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CycleDirectedGraphDFS {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
          graph.put(i, new HashSet<>());
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
          int from = in.nextInt();
          int to = in.nextInt();
          graph.get(from).add(to);
        }

        System.out.println(hasCycle(graph));
      }
    }
  }

  // O(V + E) / O(V + E)
  public static boolean hasCycle(Map<Integer, Set<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    boolean[] callSt = new boolean[graph.size()];

    for (int i = 0; i < graph.size(); i++) {
      if (!visited[i]) {
        if (dfs(graph, visited, callSt, i)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(Map<Integer, Set<Integer>> graph,
                             boolean[] visited, boolean[] callSt,
                             int currVertex) {
    if (callSt[currVertex]) {
      return true;
    }

    visited[currVertex] = true;
    callSt[currVertex] = true;

    for (int neighbour : graph.get(currVertex)) {
      if (dfs(graph, visited, callSt, neighbour)) {
        return true;
      }
    }

    callSt[currVertex] = false;
    return false;
  }
}