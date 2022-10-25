import java.util.Scanner;

public class PrefixSum {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];
      int[] ps = new int[n];
      int[] tree = new int[4 * n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        ps[i] = a[i];
      }

      // prefix sum array
      for (int i = 1; i < n; i++) {
        ps[i] += ps[i - 1];
      }

      // segment tree
      build(tree, 0, 0, n - 1, a);

      int nq = in.nextInt();
      for (int i = 0; i < nq; i++) {
        int l = in.nextInt();
        int r = in.nextInt();

        if (l == 0) {
          System.out.printf("%d ", ps[r]);
        } else {
          System.out.printf("%d ", ps[r] - ps[l - 1]);
        }

        System.out.println(query(tree, 0, 0, n - 1, l, r));
      }
    }
  }

  private static void build(int[] tree, int node, int start, int end, int[] a) {
    if (start == end) {
      tree[node] = a[start];
    } else {
      int mid = start + (end - start) / 2;
      build(tree, 2 * node + 1, start, mid, a);
      build(tree, 2 * node + 2, mid + 1, end, a);
      tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
  }

  private static void update(int[] tree, int node, int start, int end, int idx,
                             int val) {
    if (start == end) {
      tree[node] += val;
    } else {
      int mid = start + (end - start) / 2;
      if (start <= idx && idx <= mid) {
        update(tree, node, start, mid, idx, val);
      } else {
        update(tree, node, mid + 1, end, idx, val);
      }

      tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
  }

  private static int query(int[] tree, int node, int start, int end, int l,
                           int r) {
    if (start > r || end < l) {
      return 0;
    }

    if (l <= start && end <= r) {
      return tree[node];
    }

    int mid = start + (end - start) / 2;
    int lval = query(tree, 2 * node + 1, start, mid, l, r);
    int rval = query(tree, 2 * node + 2, mid + 1, end, l, r);

    return lval + rval;
  }
}