import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class DSUF {
  private int[] parent;
  private int[] rank;

  public DSUF(int n) {
    this.parent = new int[n];
    for (int i = 0; i < n; i++) {
      this.parent[i] = i;
    }

    this.rank = new int[n];
  }

  // O(1)
  public int find(int p) {
    if (p != parent[p]) {
      p = find(parent[p]);
    }

    return parent[p];
  }

  // O(1)
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

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int op = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();

        if (op == 0) {
          dsuf.union(p, q);
        } else {
          System.out.printf("%d\n", dsuf.find(p) == dsuf.find(q) ? 1 : 0);
        }
      }
    }
  }
}