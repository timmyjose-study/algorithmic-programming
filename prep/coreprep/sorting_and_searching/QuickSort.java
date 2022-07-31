import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        b[i] = a[i];
      }

      display(a, n);
      sort(a, 0, n - 1);
      display(a, n);

      if (isSorted(a) && isSameAsOriginalArray(b, a)) {
        System.out.println("PASSED");
      } else {
        System.out.println("FAILED");
      }
    }
  }

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  // O(nlogn), O(n^2)
  private static void sort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int k = ThreadLocalRandom.current().nextInt(high - low) + low;
    swap(a, low, k);

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

  private static boolean isSorted(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] > a[i + 1]) {
        return false;
      }
    }
    return true;
  }

  private static boolean isSameAsOriginalArray(int[] a, int[] b) {
    Arrays.sort(a);
    return Arrays.equals(a, b);
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}