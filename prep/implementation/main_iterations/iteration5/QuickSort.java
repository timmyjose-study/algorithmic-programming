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

      display(a);
      sort(a, n);
      display(a);
    }
  }

  public static void sort(int[] a, int n) { sort(a, 0, n - 1); }

  private static void sort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int r = ThreadLocalRandom.current().nextInt(high - low + 1) + low;
    swap(a, low, r);

    int mid = partition(a, low, high);
    sort(a, low, mid - 1);
    sort(a, mid + 1, high);
  }

  private static int partition(int[] a, int low, int high) {
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

  private static void display(int[] a) {
    for (int e : a) {
      System.out.printf("%d ", e);
    }
    System.out.println();
  }
}