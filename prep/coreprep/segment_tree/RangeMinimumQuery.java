import java.util.Scanner;

public class RangeMinimumQuery {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }
      in.nextLine();

      int[] tree = new int[4 * n];

      build(tree, 0, 0, n - 1, a);

      for (int i = 0; i < nq; i++) {
        String[] query = in.nextLine().split(" ");

        if (query[0].equals("q")) {
          int l = Integer.parseInt(query[1]);
          int r = Integer.parseInt(query[2]);

          System.out.println(query(tree, 0, 0, n - 1, l - 1, r - 1));
        } else {
          int idx = Integer.parseInt(query[1]);
          int val = Integer.parseInt(query[2]);

          update(tree, 0, 0, n - 1, idx - 1, val);
        }
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
      tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
  }

  private static void update(int[] tree, int node, int start, int end, int idx,
                             int val) {
    if (start == end) {
      tree[node] = val;
    } else {
      int mid = start + (end - start) / 2;

      if (start <= idx && idx <= mid) {
        update(tree, 2 * node + 1, start, mid, idx, val);
      } else {
        update(tree, 2 * node + 2, mid + 1, end, idx, val);
      }

      tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
  }

  private static int query(int[] tree, int node, int start, int end, int l,
                           int r) {
    if (start > r || end < l) {
      return Integer.MAX_VALUE;
    }

    if (l <= start && end <= r) {
      return tree[node];
    }

    int mid = start + (end - start) / 2;
    int lmin = query(tree, 2 * node + 1, start, mid, l, r);
    int rmin = query(tree, 2 * node + 2, mid + 1, end, l, r);

    return Math.min(lmin, rmin);
  }
}