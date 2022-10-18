import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Kruskal {
  static class DSUF {
    private int[] parent;
    private int[] rank;

    DSUF(int n) {
      this.rank = new int[n];
      this.parent = new int[n];

      for (int i = 0; i < n; i++) {
        this.parent[i] = i;
      }
    }

    int find(int p) {
      if (p != parent[p]) {
        p = find(parent[p]);
      }

      return parent[p];
    }

    void union(int p, int q) {
      int pid = find(p);
      int qid = find(q);

      if (pid == qid) {
        return;
      }

      if (rank[pid] > rank[qid]) {
        parent[qid] = pid;
      } else {
        parent[pid] = qid;

        if (rank[pid] == rank[qid]) {
          rank[qid]++;
        }
      }
    }
  }

  record Edge(int from, int to, int weight) {}

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int m = in.nextInt();
      List<Edge> edges = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int weight = in.nextInt();

        edges.add(new Edge(from, to, weight));
      }

      kruskal(dsuf, edges);
    }
  }

  // O(ElogE) / O(E + V)
  public static void kruskal(DSUF dsuf, List<Edge> edges) {
    List<Edge> mstEdges = new ArrayList<>();
    int mstCost = 0;

    edges.sort((e1, e2) -> Integer.compare(e1.weight, e2.weight));

    for (Edge e : edges) {
      if (dsuf.find(e.from()) != dsuf.find(e.to())) {
        mstEdges.add(e);
        mstCost += e.weight();
        dsuf.union(e.from(), e.to());
      }
    }

    System.out.println(mstCost);
    for (Edge e : mstEdges) {
      System.out.printf("%d %d\n", e.from(), e.to());
    }
  }
}