import java.util.*;

public class HeapSort {
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

  private static int left(int p) { return 2 * p + 1; }

  private static int right(int p) { return 2 * p + 2; }

  private static void siftDown(int[] a, int i, int n) {
    int maxIdx = i;

    int leftIdx = left(i);
    if (leftIdx < n && a[leftIdx] > a[maxIdx]) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(i);
    if (rightIdx < n && a[rightIdx] > a[maxIdx]) {
      maxIdx = rightIdx;
    }

    if (maxIdx != i) {
      swap(a, i, maxIdx);
      siftDown(a, maxIdx, n);
    }
  }

  private static void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 0; i--) {
      siftDown(a, i, n);
    }
  }

  private static void sort(int[] a, int n) {
    buildHeap(a, n);

    int len = n;
    for (int i = 0; i < n - 1; i++) {
      swap(a, 0, len - 1);
      len--;
      siftDown(a, 0, len);
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