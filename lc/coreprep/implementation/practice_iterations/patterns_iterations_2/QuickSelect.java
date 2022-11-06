import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class QuickSelect {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int nq = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        while (nq-- > 0) {
          int k = in.nextInt();
          System.out.println(quickSelect(a, k));
        }
      }
    }
  }

  // O(nlogn) / O(n)
  public static int quickSelect(int[] a, int k) {
    return quickSelect(a, 0, a.length - 1, k);
  }

  private static int quickSelect(int[] a, int low, int high, int k) {
    int mid = partition(a, low, high);
    if (mid == k) {
      return a[mid];
    } else if (mid < k) {
      return quickSelect(a, mid + 1, high, k);
    }
    return quickSelect(a, low, mid - 1, k);
  }

  private static int medianOfMedians(int[] a, int low, int high) {
    int n = high - low + 1;

    if (n < 5) {
      return a[low];
    }

    int numPartitions = n / 5;
    int[] medians = new int[numPartitions];
    for (int i = 0; i < numPartitions; i++) {
      int start = low + i * 5;
      Arrays.sort(a, start, start + 5);
      medians[i] = a[start + 2];
    }

    return partition(medians, 0, numPartitions - 1);
  }

  private static int partition(int[] a, int low, int high) {
    int median = medianOfMedians(a, low, high);
    for (int i = low; i <= high; i++) {
      if (a[i] == median) {
        swap(a, i, low);
        break;
      }
    }

    int pivot = a[low];
    int j = low;

    for (int i = low + 1; i <= high; i++) {
      if (a[i] <= pivot) {
        j++;

        if (j != i) {
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