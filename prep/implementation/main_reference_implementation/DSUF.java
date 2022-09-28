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

  // O(1)
  private void makeSet(int p) {
    this.rank[p] = 0;
    this.parent[p] = p;
  }

  // O(1)
  public int find(int p) {
    if (p != parent[p]) {
      parent[p] = find(parent[p]);
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
          System.out.println(dsuf.find(p) == dsuf.find(q) ? 1 : 0);
          break;
        }
      }
    }
  }
}