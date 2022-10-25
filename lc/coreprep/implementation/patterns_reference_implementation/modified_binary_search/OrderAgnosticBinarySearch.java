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

        System.out.println(binarySearch(a, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int binarySearch(int[] a, int k) {
    if (a.length == 1) {
      return (a[0] == k ? 0 : -1);
    }

    int low = 0, high = a.length - 1;
    boolean isIncreasing = a[low] <= a[high];

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] == k) {
        return mid;
      } else if (a[mid] < k) {
        if (isIncreasing) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        if (isIncreasing) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }

    return -1;
  }
}