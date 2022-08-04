import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();

      Graph g1 = new AdjacencyMatrix(n, Graph.GraphType.DIRECTED);
      Graph g2 = new AdjacencySet(n, Graph.GraphType.DIRECTED);

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g1.addEdge(from, to);
        g2.addEdge(from, to);
      }

      var list1 = sort(g1);

      if (!list1.isEmpty()) {
        for (var v : list1) {
          System.out.printf("%d ", v);
        }
        System.out.println();
      }

      var list2 = sort(g2);
      if (!list2.isEmpty()) {
        for (var v : list2) {
          System.out.printf("%d ", v);
        }
        System.out.println();
      }
    }
  }

  // O(|V| + |E|)
  public static List<Integer> sort(Graph g) {
    List<Integer> sortedList = new ArrayList<>();
    Queue<Integer> q = new ArrayDeque<>();
    Map<Integer, Integer> indegMap = new HashMap<>();

    for (int i = 0; i < g.size(); i++) {
      int indeg = g.getIndegree(i);
      indegMap.put(i, indeg);

      if (indeg == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int v = q.poll();

      sortedList.add(v);
      for (int vv : g.getAdjacentVertices(v)) {
        int indeg = indegMap.get(vv);
        indegMap.put(vv, indeg - 1);

        if (indeg - 1 == 0) {
          q.add(vv);
        }
      }
    }

    if (sortedList.size() != g.size()) {
      throw new IllegalStateException("cycle detected during sort");
    }

    return sortedList;
  }
}