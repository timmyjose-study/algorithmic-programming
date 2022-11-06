import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumberQuickSelect {
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

        System.out.println(kthSmallest(a, k - 1));
      }
    }
  }

  // O(n2) / O(n)
  public static int kthSmallest(int[] a, int k) {
    return quickSelect(a, 0, a.length - 1, k);
  }

  private static int quickSelect(int[] a, int low, int high, int k) {
    int r = ThreadLocalRandom.current().nextInt(high - low + 1) + low;
    swap(a, low, r);

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

    if (low != j) {
      swap(a, low, j);
    }

    return j;
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}