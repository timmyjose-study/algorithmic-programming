import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AllTasksSchedulingOrder {
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

        var res = allTasksSchedulingOrder(graph, indegree);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(V! x E) / O(V! x E)
  public static List<List<Integer>>
  allTasksSchedulingOrder(Map<Integer, Set<Integer>> graph,
                          Map<Integer, Integer> indegree) {
    Queue<Integer> q = new ArrayDeque<>();
    for (var entry : indegree.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    List<List<Integer>> all = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    allTasksSchedulingOrder(graph, indegree, q, curr, all);

    return all;
  }

  private static void allTasksSchedulingOrder(Map<Integer, Set<Integer>> graph,
                                              Map<Integer, Integer> indegree,
                                              Queue<Integer> q,
                                              List<Integer> curr,
                                              List<List<Integer>> all) {
    if (!q.isEmpty()) {
      for (int v : q) {
        curr.add(v);

        Queue<Integer> nextq = new ArrayDeque<>(q);
        nextq.remove(v);

        for (int neighbour : graph.get(v)) {
          indegree.put(neighbour, indegree.get(neighbour) - 1);

          if (indegree.get(neighbour) == 0) {
            nextq.add(neighbour);
          }
        }

        allTasksSchedulingOrder(graph, indegree, nextq, curr, all);

        curr.remove(curr.size() - 1);
        for (int neighbour : graph.get(v)) {
          indegree.put(neighbour, indegree.get(neighbour) + 1);
        }
      }
    }

    if (curr.size() == graph.size()) {
      all.add(new ArrayList<>(curr));
    }
  }
}