import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class QuickSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        display(a);
        sort(a);
        display(a);
      }
    }
  }

  // O(nlogn) / O(n)
  public static void sort(int[] a) { sort(a, 0, a.length - 1); }

  private static void sort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int mid = partition(a, low, high);
    sort(a, low, mid - 1);
    sort(a, mid + 1, high);
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

  private static void display(int[] a) {
    for (int e : a) {
      System.out.printf("%d ", e);
    }
    System.out.println();
  }
}