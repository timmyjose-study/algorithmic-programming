import java.util.*;

public class Kruskal {
  static class DSUF {
    private int size;
    private int[] parent;
    private int[] rank;

    DSUF(int size) {
      this.size = size;
      this.parent = new int[size];
      this.rank = new int[size];

      for (int i = 0; i < size; i++) {
        makeSet(i);
      }
    }

    void makeSet(int p) {
      this.parent[p] = p;
      this.rank[p] = 0;
    }

    int find(int p) {
      if (p != parent[p]) {
        parent[p] = find(parent[p]);
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

  static class Edge {
    int from;
    int to;

    Edge(int from, int to) {
      this.from = from;
      this.to = to;
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

    @Override
    public String toString() {
      return from + " " + to;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Edge> edges = new ArrayList<>();
      Map<Edge, Integer> weights = new HashMap<>();

      int n = in.nextInt();
      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        Edge edge = new Edge(from, to);
        edges.add(edge);

        int w = in.nextInt();
        weights.put(edge, w);
      }

      kruskal(n, edges, weights);
    }
  }

  // O(|E|log|V|)
  private static void kruskal(int numVertices, List<Edge> edges,
                              Map<Edge, Integer> weights) {
    List<Edge> mstEdges = new ArrayList<>();
    DSUF dsuf = new DSUF(numVertices);

    edges.sort((e1, e2) -> Integer.compare(weights.get(e1), weights.get(e2)));

    for (Edge e : edges) {
      if (dsuf.find(e.from) != dsuf.find(e.to)) {
        mstEdges.add(e);
        dsuf.union(e.from, e.to);
      }
    }

    long mstCost = 0L;
    for (Edge e : mstEdges) {
      mstCost += (long)weights.get(e);
    }

    System.out.println(mstCost);
    for (Edge e : mstEdges) {
      System.out.println(e);
    }
  }
}