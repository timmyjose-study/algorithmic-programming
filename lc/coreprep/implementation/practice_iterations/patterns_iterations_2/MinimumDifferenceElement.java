import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumDifferenceElement {
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

        System.out.println(minDiffElement(a, 0, n - 1, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int minDiffElement(int[] a, int low, int high, int k) {
    if (k < a[low]) {
      return a[low];
    }

    if (k > a[high]) {
      return a[high];
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] < k) {
        low = mid + 1;
      } else if (a[mid] > k) {
        high = mid - 1;
      } else {
        return a[mid];
      }
    }

    if (Math.abs(k - a[low]) < Math.abs(k - a[high])) {
      return a[low];
    }
    return a[high];
  }
}