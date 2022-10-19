import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class OrderAgnosticBinarySearch {
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

        System.out.println(binarySearch(a, 0, n - 1, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int binarySearch(int[] a, int low, int high, int elem) {
    boolean isNonDecreasing = a[low] <= a[high] ? true : false;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] == elem) {
        return mid;
      } else {
        if (isNonDecreasing) {
          if (a[mid] < elem) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        } else {
          if (a[mid] < elem) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
      }
    }

    return -1;
  }
}