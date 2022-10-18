import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SegmentTreeRangeMinimumQuery {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      int[] tree = new int[4 * n];

      build(tree, 0, 0, n - 1, a);

      while (nq-- > 0) {
        String cmd = in.next();
        int l = in.nextInt();
        int r = in.nextInt();

        switch (cmd) {
        case "q":
          System.out.printf("%d\n", query(tree, 0, 0, n - 1, l - 1, r - 1));
          break;

        case "u":
          update(tree, 0, 0, n - 1, l - 1, r, a);
          break;
        }
      }
    }
  }

  // O(n)
  private static void build(int[] tree, int node, int start, int end, int[] a) {
    if (start == end) {
      tree[node] = a[start];
    } else {
      int mid = start + (end - start) / 2;

      build(tree, 2 * node + 1, start, mid, a);
      build(tree, 2 * node + 2, mid + 1, end, a);

      tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
  }

  // O(logn)
  private static void update(int[] tree, int node, int start, int end, int idx,
                             int val, int[] a) {
    if (start == end) {
      tree[node] = val;
      a[idx] = val;
    } else {
      int mid = start + (end - start) / 2;

      if (idx <= mid) {
        update(tree, 2 * node + 1, start, mid, idx, val, a);
      } else {
        update(tree, 2 * node + 2, mid + 1, end, idx, val, a);
      }

      tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
  }

  // O(logn)
  private static int query(int[] tree, int node, int start, int end, int l,
                           int r) {
    if (r < start || end < l) {
      return Integer.MAX_VALUE;
    }

    if (l <= start && end <= r) {
      return tree[node];
    }

    int mid = start + (end - start) / 2;
    return Math.min(query(tree, 2 * node + 1, start, mid, l, r),
                    query(tree, 2 * node + 2, mid + 1, end, l, r));
  }
}