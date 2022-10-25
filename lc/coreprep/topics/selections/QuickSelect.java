import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      while (nq-- > 0) {
        int idx = in.nextInt();

        if (idx >= n) {
          throw new IllegalArgumentException("invalid index");
        }

        System.out.println(quickSelect(a, 0, n - 1, idx));
      }
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  // O(N^2), but effectively O(N) on average.
  private static int quickSelect(int[] a, int low, int high, int k) {
    int r = ThreadLocalRandom.current().nextInt(high - low + 1) + low;

    if (r != low) {
      swap(a, r, low);
    }

    int mid = partition(a, low, high);

    if (mid == k) {
      return a[mid];
    } else if (mid < k) {
      return quickSelect(a, mid + 1, high, k);
    }

    return quickSelect(a, low, mid - 1, k);
  }

  private static int partition(int[] a, int low, int high) {
    int pivot = a[low];
    int j = low;

    for (int i = low + 1; i <= high; i++) {
      if (a[i] <= pivot) {
        j++;

        if (i != j) {
          swap(a, i, j);
        }
      }
    }

    if (j != low) {
      swap(a, j, low);
    }

    return j;
  }
}