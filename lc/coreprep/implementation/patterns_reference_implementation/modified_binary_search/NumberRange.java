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

        int[] idx = findMinMax(a, k);
        System.out.printf("%d %d\n", idx[0], idx[1]);
      }
    }
  }

  static enum Find {
    MIN,
    MAX;
  }

  // O(logn) / O(1)
  public static int[] findMinMax(int[] a, int k) {
    int[] idx = new int[] {-1, -1};

    idx[0] = binarySearch(a, 0, a.length - 1, k, Find.MIN);
    idx[1] = binarySearch(a, 0, a.length - 1, k, Find.MAX);

    return idx;
  }

  private static int binarySearch(int[] a, int low, int high, int k,
                                  Find find) {
    int keyIndex = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] < k) {
        low = mid + 1;
      } else if (a[mid] > k) {
        high = mid - 1;
      } else {
        keyIndex = mid;

        if (find == Find.MIN) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }

    return keyIndex;
  }
}