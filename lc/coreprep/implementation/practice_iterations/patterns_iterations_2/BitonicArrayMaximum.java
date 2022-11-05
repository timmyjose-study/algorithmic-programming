import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class BitonicArrayMaximum {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(bitonicArrayMaximum(a, 0, n - 1));
      }
    }
  }

  // O(logn) / O(1)
  public static int bitonicArrayMaximum(int[] a, int low, int high) {
    while (low < high) {
      int mid = low + (high - low) / 2;

      if (a[mid] > a[mid + 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return a[low];
  }
}