import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AllTasksSchedulingOrder {
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

        var allOrderings = allSchedulingOrders(g, indegree);
        for (var ordering : allOrderings) {
          for (int order : ordering) {
            System.out.printf("%d ", order);
          }
          System.out.println();
        }
      }
    }
  }

  // O(V! x E) / O(V! x E)
  public static List<List<Integer>>
  allSchedulingOrders(Map<Integer, Set<Integer>> g,
                      Map<Integer, Integer> indegree) {
    List<List<Integer>> allOrderings = new ArrayList<>();

    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < g.size(); i++) {
      if (indegree.get(i) == 0) {
        q.add(i);
      }
    }

    allSchedulingOrders(g, indegree, q, new ArrayList<>(), allOrderings);

    return allOrderings;
  }

  private static void allSchedulingOrders(Map<Integer, Set<Integer>> g,
                                          Map<Integer, Integer> indegree,
                                          Queue<Integer> candidates,
                                          List<Integer> currOrdering,
                                          List<List<Integer>> allOrderings) {
    if (!candidates.isEmpty()) {
      for (int candidate : candidates) {
        Queue<Integer> withQueue = new ArrayDeque<>(candidates);
        currOrdering.add(candidate);
        withQueue.remove(candidate);

        for (int neighbour : g.get(candidate)) {
          indegree.put(neighbour, indegree.get(neighbour) - 1);

          if (indegree.get(neighbour) == 0) {
            withQueue.add(neighbour);
          }
        }

        allSchedulingOrders(g, indegree, withQueue, currOrdering, allOrderings);

        currOrdering.remove(currOrdering.size() - 1);
        for (int neighbour : g.get(candidate)) {
          indegree.put(neighbour, indegree.get(neighbour) + 1);
        }
      }
    }

    if (currOrdering.size() == g.size()) {
      allOrderings.add(new ArrayList<>(currOrdering));
    }
  }
}