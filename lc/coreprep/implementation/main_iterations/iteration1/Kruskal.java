import java.util.*;

public class Kruskal {
  static class DSUF {
    private int[] rank;
    private int[] parent;

    DSUF(int n) {
      this.rank = new int[n];
      this.parent = new int[n];

      for (int i = 0; i < n; i++) {
        makeSet(i);
      }
    }

    private void makeSet(int p) {
      this.rank[p] = 0;
      this.parent[p] = p;
    }

    public int find(int p) {
      if (p != parent[p]) {
        p = find(parent[p]);
      }

      return parent[p];
    }

    public void union(int p, int q) {
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

  static class Edge {
    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.from, this.to);
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Edge)) {
        return false;
      }

      Edge other = (Edge)o;
      return this.from == other.from && this.to == other.to ||
          this.from == other.to && this.to == other.from;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int nq = in.nextInt();
      List<Edge> edges = new ArrayList<>();
      while (nq-- > 0) {
        int from = in.nextInt();
        int to = in.nextInt();
        int weight = in.nextInt();

        edges.add(new Edge(from, to, weight));
      }

      kruskal(dsuf, edges);
    }
  }

  // O(|E|log|V|)
  private static void kruskal(DSUF dsuf, List<Edge> edges) {
    edges.sort((e1, e2) -> Integer.compare(e1.weight, e2.weight));

    List<Edge> mstEdges = new ArrayList<>();

    int minCost = 0;
    for (Edge edge : edges) {
      if (dsuf.find(edge.from) != dsuf.find(edge.to)) {
        dsuf.union(edge.from, edge.to);
        mstEdges.add(edge);
        minCost += edge.weight;
      }
    }

    System.out.println(minCost);
    for (Edge edge : mstEdges) {
      System.out.printf("%d %d\n", edge.from, edge.to);
    }
  }
}