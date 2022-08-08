import java.util.Scanner;

public class DisjointSetUnionFind {
  static class DSUF {
    private int[] parent;
    private int[] rank;

    DSUF(int n) {
      this.parent = new int[n + 1];
      this.rank = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        makeSet(i);
      }
    }

    // O(1)
    void makeSet(int p) {
      this.parent[p] = p;
      this.rank[p] = 0;
    }

    // O(1)
    int find(int p) {
      if (p != parent[p]) {
        parent[p] = find(parent[p]);
      }
      return parent[p];
    }

    // O(1)
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

      int q = in.nextInt();
      in.nextLine();
      for (int i = 0; i < q; i++) {
        String[] cmd = in.nextLine().trim().split(" ");
        int c = Integer.parseInt(cmd[0]);
        int x = Integer.parseInt(cmd[1]);
        int y = Integer.parseInt(cmd[2]);

        if (c == 0) {
          dsuf.union(x, y);
        } else {
          if (dsuf.find(x) == dsuf.find(y)) {
            System.out.println(1);
          } else {
            System.out.println(0);
          }
        }
      }
    }
  }
}