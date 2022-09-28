import java.util.*;

public class DSUF {
  private int[] rank;
  private int[] parent;

  public DSUF(int size) {
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
      if (this.rank[qid] == this.rank[pid]) {
        this.rank[qid]++;
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      DSUF dsuf = new DSUF(n);

      int nq = in.nextInt();
      while (nq-- > 0) {
        int cmd = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();

        switch (cmd) {
        case 0:
          dsuf.union(p, q);
          break;

        case 1:
          System.out.println(dsuf.find(p) == dsuf.find(q) ? "1" : "0");
          break;
        }
      }
    }
  }
}