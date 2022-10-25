import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumberInSortedMatrix {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            a[i][j] = in.nextInt();
          }
        }

        int nq = in.nextInt();
        while (nq-- > 0) {
          int k = in.nextInt();
          System.out.println(kthSmallestNumberInSortedMatix(a, k));
        }
      }
    }
  }

  static class SmallLarge {
    int smallestGreaterThanMid;
    int largestLesserThanOrEqualToMid;
  }

  // O(n log(max - min)) / O(1)
  public static int kthSmallestNumberInSortedMatix(int[][] a, int k) {
    int n = a.length;
    int m = a[0].length;

    int low = a[0][0];
    int high = a[n - 1][m - 1];

    while (low < high) {
      int mid = low + (high - low) / 2;

      SmallLarge range = new SmallLarge();
      int countLesserThanOrEqualToMid = count(a, n, m, mid, range);

      if (countLesserThanOrEqualToMid == k) {
        return range.largestLesserThanOrEqualToMid;
      } else if (countLesserThanOrEqualToMid < k) {
        low = range.smallestGreaterThanMid;
      } else {
        high = range.largestLesserThanOrEqualToMid;
      }
    }

    return low;
  }

  private static int count(int[][] a, int n, int m, int mid, SmallLarge range) {
    int row = n - 1, col = 0;
    int count = 0;

    range.smallestGreaterThanMid = Integer.MAX_VALUE;
    range.largestLesserThanOrEqualToMid = Integer.MIN_VALUE;

    while (row >= 0 && col < m) {
      if (a[row][col] > mid) {
        range.smallestGreaterThanMid =
            Math.min(range.smallestGreaterThanMid, a[row][col]);
        row--;
      } else {
        range.largestLesserThanOrEqualToMid =
            Math.max(range.largestLesserThanOrEqualToMid, a[row][col]);
        count += row + 1;
        col++;
      }
    }

    return count;
  }
}