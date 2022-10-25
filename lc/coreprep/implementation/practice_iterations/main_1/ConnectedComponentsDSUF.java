import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(E) / O(V)
public class ConnectedComponentsDSUF {
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

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        if (dsuf.find(from) != dsuf.find(to)) {
          dsuf.union(from, to);
        }
      }

      int nq = in.nextInt();
      while (nq-- > 0) {
        int from = in.nextInt();
        int to = in.nextInt();

        System.out.println((dsuf.find(from) == dsuf.find(to) ? "yes" : "no"));
      }
    }
  }
}