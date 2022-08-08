import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

  public static void main(String[] args) throws IOException {
    try (BufferedReader in =
             new BufferedReader(new InputStreamReader(System.in))) {
      String[] params = in.readLine().trim().split(" ");
      int n = Integer.parseInt(params[0]);
      int q = Integer.parseInt(params[1]);

      DSUF dsuf = new DSUF(n);
      for (int i = 0; i < q; i++) {
        String[] inp = in.readLine().trim().split(" ");
        int cmd = Integer.parseInt(inp[0]);
        int x = Integer.parseInt(inp[1]);
        int y = Integer.parseInt(inp[2]);

        if (cmd == 0) {
          dsuf.union(x, y);
        } else if (dsuf.find(x) == dsuf.find(y)) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
      }
    }
  }
}