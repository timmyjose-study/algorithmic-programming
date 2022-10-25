import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TaskScheduling {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        Map<Integer, Set<Integer>> g = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < n; i++) {
          g.put(i, new HashSet<>());
          indegree.put(i, 0);
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
          int from = in.nextInt();
          int to = in.nextInt();

          g.get(from).add(to);
          indegree.put(to, indegree.get(to) + 1);
        }

        System.out.println(canSchedule(g, indegree));
      }
    }
  }

  // O(V + E) / O(V + E)
  public static boolean canSchedule(Map<Integer, Set<Integer>> g,
                                    Map<Integer, Integer> indegree) {
    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < g.size(); i++) {
      if (indegree.get(i) == 0) {
        q.add(i);
      }
    }

    List<Integer> ordering = new ArrayList<>();
    while (!q.isEmpty()) {
      int v = q.poll();

      ordering.add(v);

      for (int neighbour : g.get(v)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);
        if (indegree.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    return ordering.size() == g.size();
  }
}