import java.util.*;

public class Kruskal {
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

  static class DSUF {
    private int[] rank;
    private int[] parent;

    DSUF(int size) {
      this.rank = new int[size];
      this.parent = new int[size];

      for (int i = 0; i < size; i++) {
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
  }

  public static void kruskal(DSUF dsuf, List<Edge> edges) {
    edges.sort((e1, e2) -> Integer.compare(e1.weight, e2.weight));

    List<Edge> mstEdges = new ArrayList<>();
    int mstCost = 0;
    for (Edge edge : edges) {
      int from = edge.from;
      int to = edge.to;

      if (dsuf.find(from) != dsuf.find(to)) {
        mstEdges.add(edge);
        mstCost += edge.weight;
        dsuf.union(from, to);
      }
    }

    System.out.println(mstCost);
    for (Edge edge : mstEdges) {
      System.out.printf("%d %d\n", edge.from, edge.to);
    }
  }
}