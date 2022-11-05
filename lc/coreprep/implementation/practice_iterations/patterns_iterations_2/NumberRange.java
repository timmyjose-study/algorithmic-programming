import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NumberRange {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = findMinMaxPos(a, 0, n - 1, k);
        System.out.printf("%d %d\n", res[0], res[1]);
      }
    }
  }

  static enum Find {
    MIN,
    MAX;
  }

  // O(logn) / O(1)
  public static int[] findMinMaxPos(int[] a, int low, int high, int k) {
    int minPos = binarySearch(a, low, high, k, Find.MIN);
    int maxPos = binarySearch(a, low, high, k, Find.MAX);

    return new int[] {minPos, maxPos};
  }

  private static int binarySearch(int[] a, int low, int high, int k,
                                  Find find) {
    int lastPos = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] < k) {
        low = mid + 1;
      } else if (a[mid] > k) {
        high = mid - 1;
      } else {
        lastPos = mid;

        if (find == Find.MIN) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }

    return lastPos;
  }
}