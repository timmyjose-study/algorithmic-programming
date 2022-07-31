import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
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

  // O(nlogn)
  private static void sort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int mid = low + (high - low) / 2;

    sort(a, low, mid);
    sort(a, mid + 1, high);
    merge(a, low, mid, high);
  }

  private static void merge(int[] a, int p, int q, int r) {
    int llen = q - p + 1;
    int rlen = r - q;

    int[] left = new int[llen];
    for (int i = 0; i < llen; i++) {
      left[i] = a[p + i];
    }

    int[] right = new int[rlen];
    for (int i = 0; i < rlen; i++) {
      right[i] = a[q + i + 1];
    }

    int lpos = 0, rpos = 0;
    for (int k = p; k <= r; k++) {
      if (lpos < llen && rpos < rlen) {
        if (left[lpos] <= right[rpos]) {
          a[k] = left[lpos++];
        } else {
          a[k] = right[rpos++];
        }
      } else if (lpos == llen) {
        a[k] = right[rpos++];
      } else {
        a[k] = left[lpos++];
      }
    }
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