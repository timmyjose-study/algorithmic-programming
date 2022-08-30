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
}