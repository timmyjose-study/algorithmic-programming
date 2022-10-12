import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(1)
public class PairWithTargetSumBinarySearch {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int lpos = -1, rpos = -1;
        for (int i = 0; i < n; i++) {
          rpos = binarySearch(a, 0, n - 1, s - a[i]);
          if (rpos != -1) {
            lpos = i;
            break;
          }
        }

        System.out.printf("%d %d\n", lpos, rpos);
      }
    }
  }

  private static int binarySearch(int[] a, int low, int high, int elem) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] == elem) {
        return mid;
      } else if (a[mid] < elem) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }
}