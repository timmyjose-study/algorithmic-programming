import java.util.Scanner;

public class Main {
  static class DSUF {
    private int[] parent;
    private int[] rank;

    DSUF(int n) {
      this.parent = new int[n];
      this.rank = new int[n];

      for (int i = 0; i < n; i++) {
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

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();

        dsuf.union(x, y);
      }

      int q = in.nextInt();
      for (int i = 0; i < q; i++) {
        int x = in.nextInt();
        int y = in.nextInt();

        if (dsuf.find(x) == dsuf.find(y)) {
          System.out.println("yes");
        } else {
          System.out.println("no");
        }
      }
    }
  }
}