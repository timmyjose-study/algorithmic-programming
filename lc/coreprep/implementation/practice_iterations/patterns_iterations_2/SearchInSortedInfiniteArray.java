import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SearchInSortedInfiniteArray {
  static class ArrayReader {
    int[] a;

    ArrayReader(int[] a) { this.a = a; }

    int get(int idx) {
      if (idx >= a.length) {
        return Integer.MAX_VALUE;
      }
      return a[idx];
    }
  }

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

        ArrayReader arr = new ArrayReader(a);
        System.out.println(binarySearch(arr, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int binarySearch(ArrayReader arr, int k) {
    int low = 0, high = 1;
    while (arr.get(high) < k) {
      low = high;
      high <<= 1;
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr.get(mid) < k) {
        low = mid + 1;
      } else if (arr.get(mid) > k) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}