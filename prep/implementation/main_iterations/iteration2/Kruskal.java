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
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Edge)) {
        return false;
      }

      Edge other = (Edge)o;
      return ((this.from == other.from && this.to == other.to) ||
              (this.to == other.from && this.from == other.to)) &&
          (this.weight == other.weight);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.from, this.to, this.weight);
    }
  }

  public static void kruskal(DSUF dsuf, List<Edge> edges) {
    edges.sort((e1, e2) -> Integer.compare(e1.weight, e2.weight));

    List<Edge> mstEdges = new ArrayList<>();
    int mstCost = 0;

    for (Edge edge : edges) {
      if (dsuf.find(edge.from) != dsuf.find(edge.to)) {
        dsuf.union(edge.from, edge.to);
        mstEdges.add(edge);
        mstCost += edge.weight;
      }
    }

    System.out.println(mstCost);
    for (Edge edge : mstEdges) {
      System.out.printf("%d %d\n", edge.from, edge.to);
    }
  }
}