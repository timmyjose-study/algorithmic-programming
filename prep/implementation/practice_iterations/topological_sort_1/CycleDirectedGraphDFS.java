import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CycleDirectedGraphDFS {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
          g.put(i, new HashSet<>());
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
          int from = in.nextInt();
          int to = in.nextInt();

          g.get(from).add(to);
        }

        System.out.println(hasCycle(g));
      }
    }
  }

  // O(V + E) / O(V + E)
  public static boolean hasCycle(Map<Integer, Set<Integer>> g) {
    boolean[] visited = new boolean[g.size()];
    boolean[] callSt = new boolean[g.size()];

    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        if (dfs(g, visited, callSt, i)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(Map<Integer, Set<Integer>> g, boolean[] visited,
                             boolean[] callSt, int currVertex) {
    if (callSt[currVertex]) {
      return true;
    }

    visited[currVertex] = true;
    callSt[currVertex] = true;

    for (int neighbour : g.get(currVertex)) {
      if (dfs(g, visited, callSt, neighbour)) {
        return true;
      }
    }

    callSt[currVertex] = false;
    return false;
  }
}