import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MergeSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a, n);
      sort(a, n);
      display(a, n);
    }
  }

  // O(nlogn) / O(n)
  private static void sort(int[] a, int n) { sort(a, 0, n - 1); }

  private static void sort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int mid = low + (high - low) / 2;
    sort(a, low, mid);
    sort(a, mid + 1, high);
    merge(a, low, mid, high);
  }

  private static void merge(int[] a, int low, int mid, int high) {
    if (low > mid || mid >= high) {
      return;
    }

    int llen = mid - low + 1;
    int[] left = new int[llen];
    for (int i = 0; i < llen; i++) {
      left[i] = a[low + i];
    }

    int rlen = high - mid;
    int[] right = new int[rlen];
    for (int i = 0; i < rlen; i++) {
      right[i] = a[mid + i + 1];
    }

    int lpos = 0, rpos = 0;
    for (int i = low; i <= high; i++) {
      if (lpos < llen && rpos < rlen) {
        if (left[lpos] <= right[rpos]) {
          a[i] = left[lpos++];
        } else {
          a[i] = right[rpos++];
        }
      } else if (lpos < llen) {
        a[i] = left[lpos++];
      } else {
        a[i] = right[rpos++];
      }
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}