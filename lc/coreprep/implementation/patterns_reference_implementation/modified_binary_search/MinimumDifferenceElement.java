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

        System.out.println(findClosestDiffElement(a, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int findClosestDiffElement(int[] a, int k) {
    if (k < a[0]) {
      return a[0];
    }

    if (k > a[a.length - 1]) {
      return a[a.length - 1];
    }

    int low = 0, high = a.length - 1;
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

    return (Math.abs(k - a[low]) < Math.abs(k - a[high]) ? a[low] : a[high]);
  }
}