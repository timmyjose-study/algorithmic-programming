import java.util.*;

public class ConnectedComponentsDSUF {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        dsuf.union(from, to);
      }

      int nq = in.nextInt();
      while (nq-- > 0) {
        int v1 = in.nextInt();
        int v2 = in.nextInt();
      }
    }
  }
}