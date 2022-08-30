import java.util.*;

public class SegmentTreePrefixSum {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      int[] tree = new int[4 * n];

      for (int i = 0; i < n; i++) {
        b[i] = a[i] = in.nextInt();
      }

      for (int i = 1; i < n; i++) {
        b[i] += b[i - 1];
      }

      build(tree, 0, 0, n - 1, a);

      int nq = in.nextInt();
      while (nq-- > 0) {
        int l = in.nextInt();
        int r = in.nextInt();

        System.out.printf("%d %d\n", l == 0 ? b[r] : b[r] - b[l - 1],
                          query(tree, 0, 0, n - 1, l, r));
      }
    }
  }
}