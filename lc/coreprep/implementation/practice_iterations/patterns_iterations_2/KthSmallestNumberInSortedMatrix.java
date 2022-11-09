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
          System.out.println(kthSmallest(a, n, m, k));
        }
      }
    }
  }

  static class CeilFloor {
    int ceil;
    int floor;

    CeilFloor(int ceil, int floor) {
      this.ceil = ceil;
      this.floor = floor;
    }
  }

  // O(n x log(max - min)) / O(1)
  public static int kthSmallest(int[][] a, int n, int m, int k) {
    int low = a[0][0], high = a[n - 1][m - 1];

    while (low < high) {
      int mid = low + (high - low) / 2;

      CeilFloor ceilFloor = new CeilFloor(a[n - 1][m - 1], a[0][0]);
      int count = getCount(a, n, m, mid, ceilFloor);

      if (count < k) {
        low = ceilFloor.ceil;
      } else if (count > k) {
        high = ceilFloor.floor;
      } else {
        return ceilFloor.floor;
      }
    }

    return low;
  }

  private static int getCount(int[][] a, int n, int m, int mid,
                              CeilFloor ceilFloor) {
    int row = n - 1, col = 0;
    int cnt = 0;

    while (row >= 0 && col < m) {
      if (a[row][col] > mid) {
        ceilFloor.ceil = Math.min(ceilFloor.ceil, a[row][col]);
        row--;
      } else {
        ceilFloor.floor = Math.max(ceilFloor.floor, a[row][col]);
        cnt += row + 1;
        col++;
      }
    }

    return cnt;
  }
}