import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      quickSort(a, 0, n - 1);

      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", a[i]);
      }
      System.out.println();
    }
  }

  private static void quickSort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int k = ThreadLocalRandom.current().nextInt(high - low + 1) + low;
    swap(a, low, k);

    int mid = partition(a, low, high);
    quickSort(a, low, mid - 1);
    quickSort(a, mid + 1, high);
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
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
      swap(a, low, j);
    }

    return j;
  }
}