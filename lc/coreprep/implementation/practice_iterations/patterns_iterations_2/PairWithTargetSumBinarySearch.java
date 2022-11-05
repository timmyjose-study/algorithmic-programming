import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        var res = pairWihTargetSum(a, s);
        System.out.printf("%d %d\n", res[0], res[1]);
      }
    }
  }

  // O(nlogn) / O(1)
  public static int[] pairWihTargetSum(int[] a, int s) {
    int[] pos = new int[] {-1, -1};

    for (int i = 0; i < a.length - 1; i++) {
      int idx = binarySearch(a, 0, a.length - 1, s - a[i]);

      if (idx != -1) {
        pos[0] = i;
        pos[1] = idx;
        break;
      }
    }

    return pos;
  }

  public static int binarySearch(int[] a, int low, int high, int elem) {
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