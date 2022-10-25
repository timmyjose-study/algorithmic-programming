import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
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
      sort(a);
      display(a, n);

      if (isSorted(a) && isSameAsOriginalArray(b, a)) {
        System.out.println("PASSED");
      } else {
        System.out.println("FAILED");
      }
    }
  }

  private static int parent(int idx) { return idx / 2; }
  private static int left(int idx) { return 2 * idx + 1; }
  private static int right(int idx) { return 2 * idx + 2; }

  private static void swap(int[] a, int idx1, int idx2) {
    int t = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = t;
  }

  private static void siftUp(int[] a, int idx) {
    while (idx > 0 && (a[parent(idx)] < a[idx])) {
      swap(a, idx, parent(idx));
      idx = parent(idx);
    }
  }

  private static void siftDown(int[] a, int idx, int n) {
    int maxIdx = idx;

    int l = left(idx);
    if (l < n && (a[l] > a[maxIdx])) {
      maxIdx = l;
    }

    int r = right(idx);
    if (r < n && (a[r] > a[maxIdx])) {
      maxIdx = r;
    }

    if (idx != maxIdx) {
      swap(a, idx, maxIdx);
      siftDown(a, maxIdx, n);
    }
  }

  private static void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 0; i--) {
      siftDown(a, i, n);
    }
  }

  private static void sort(int[] a) {
    int n = a.length;

    buildHeap(a, n);

    while (n > 0) {
      swap(a, 0, n - 1);
      n--;
      siftDown(a, 0, n);
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