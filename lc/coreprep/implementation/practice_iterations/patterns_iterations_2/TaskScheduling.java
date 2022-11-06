import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TaskScheduling {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
          graph.put(i, new HashSet<>());
          indegree.put(i, 0);
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
          int from = in.nextInt();
          int to = in.nextInt();

          graph.get(from).add(to);
          indegree.put(to, indegree.get(to) + 1);
        }

        System.out.println(canSchedule(graph, indegree));
      }
    }
  }

  // O(V + E) / O(V + E)
  public static boolean canSchedule(Map<Integer, Set<Integer>> graph,
                                    Map<Integer, Integer> indegree) {
    Queue<Integer> q = new ArrayDeque<>();

    for (var entry : indegree.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    List<Integer> scheduling = new ArrayList<>();
    while (!q.isEmpty()) {
      int v = q.poll();

      scheduling.add(v);

      for (int neighbour : graph.get(v)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);
        if (indegree.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    return scheduling.size() == graph.size();
  }
}