import java.util.*;

public class SegmentTreePrefixSum {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      int[] tree = new int[4 * n];

      for (int i = 0; i < n; i++) {
        a[i] = b[i] = in.nextInt();
      }

      for (int i = 1; i < n; i++) {
        b[i] += b[i - 1];
      }

      build(tree, 0, 0, n - 1, a);

      int nq = in.nextInt();
      while (nq-- > 0) {
        int l = in.nextInt();
        int r = in.nextInt();

        int psum1 = l == 0 ? b[r] : b[r] - b[l - 1];
        int psum2 = query(tree, 0, 0, n - 1, l, r);
        System.out.printf("%d %d\n", psum1, psum2);
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
                             int val, int[] a) {
    if (start == end) {
      tree[node] = val;
      a[idx] = val;
    } else {
      int mid = start + (end - start) / 2;
      if (idx >= start && idx <= mid) {
        update(tree, 2 * node + 1, start, mid, idx, val, a);
      } else {
        update(tree, 2 * node + 2, mid + 1, end, idx, val, a);
      }

      tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
  }

  private static int query(int[] tree, int node, int start, int end, int l,
                           int r) {
    if (r < start || l > end) {
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