import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SearchInSortedInfiniteArray {
  static class ArrayReader {
    private int[] a;

    ArrayReader(int[] a) { this.a = a; }

    public int get(int idx) {
      if (idx >= this.a.length) {
        return Integer.MAX_VALUE;
      }
      return this.a[idx];
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
        System.out.println(findElem(arr, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int findElem(ArrayReader arr, int k) {
    int size = 1;
    while (size < Integer.MAX_VALUE && arr.get(size - 1) < k) {
      size *= 2;
    }

    return binarySearch(arr, 0, size - 1, k);
  }

  private static int binarySearch(ArrayReader a, int low, int high, int k) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a.get(mid) < k) {
        low = mid + 1;
      } else if (a.get(mid) > k) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}