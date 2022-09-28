import java.util.*;

public class ConnectedComponentsDSUF {
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
      if (p != this.parent[p]) {
        p = find(this.parent[p]);
      }

      return this.parent[p];
    }

    public void union(int p, int q) {
      int pid = find(p);
      int qid = find(q);

      if (pid == qid) {
        return;
      }

      if (this.rank[pid] > this.rank[qid]) {
        this.parent[qid] = pid;
      } else {
        this.parent[pid] = qid;
        if (this.rank[pid] == this.rank[qid]) {
          this.rank[qid]++;
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

        dsuf.union(from, to);
      }

      int nq = in.nextInt();
      while (nq-- > 0) {
        int v1 = in.nextInt();
        int v2 = in.nextInt();

        System.out.println(dsuf.find(v1) == dsuf.find(v2) ? "yes" : "no");
      }
    }
  }
}