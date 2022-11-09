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

        var res = allPossibleSchedulings(graph, indegree);
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
  allPossibleSchedulings(Map<Integer, Set<Integer>> graph,
                         Map<Integer, Integer> indegree) {
    Queue<Integer> candidates = new ArrayDeque<>();

    for (var entry : indegree.entrySet()) {
      if (entry.getValue() == 0) {
        candidates.add(entry.getKey());
      }
    }

    List<List<Integer>> allSchedulings = new ArrayList<>();
    allPossibleSchedulings(graph, indegree, candidates, new ArrayList<>(),
                           allSchedulings);

    return allSchedulings;
  }

  public static void allPossibleSchedulings(
      Map<Integer, Set<Integer>> graph, Map<Integer, Integer> indegree,
      Queue<Integer> candidates, List<Integer> currScheduling,
      List<List<Integer>> allSchedulings) {
    if (!candidates.isEmpty()) {
      for (int c : candidates) {
        Queue<Integer> nextCandidates = new ArrayDeque<>(candidates);
        nextCandidates.remove(c);
        currScheduling.add(c);

        for (int neighbour : graph.get(c)) {
          indegree.put(neighbour, indegree.get(neighbour) - 1);
          if (indegree.get(neighbour) == 0) {
            nextCandidates.add(neighbour);
          }
        }

        allPossibleSchedulings(graph, indegree, nextCandidates, currScheduling,
                               allSchedulings);

        currScheduling.remove(currScheduling.size() - 1);
        for (int neighbour : graph.get(c)) {
          indegree.put(neighbour, indegree.get(neighbour) + 1);
        }
      }
    }

    if (currScheduling.size() == graph.size()) {
      allSchedulings.add(new ArrayList<>(currScheduling));
    }
  }
}