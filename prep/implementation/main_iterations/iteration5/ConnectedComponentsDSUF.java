import java.util.*;

public class ConnectedComponentsDSUF {
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

        if (dsuf.find(v1) == dsuf.find(v2)) {
          System.out.println("yes");
        } else {
          System.out.println("no");
        }
      }
    }
  }
}