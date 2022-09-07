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

  public static void sort(int[] a, int n) {
    buildHeap(a, n);

    int len = n;
    for (int i = 0; i < n - 1; i++) {
      swap(a, 0, len - 1);
      len--;
      siftDown(a, 0, len);
    }
  }

  private static void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 0; i--) {
      siftDown(a, i, n);
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static void siftDown(int[] a, int p, int n) {
    int maxIdx = p;

    int leftIdx = left(p);
    if (leftIdx < n && a[leftIdx] > a[maxIdx]) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(p);
    if (rightIdx < n && a[rightIdx] > a[maxIdx]) {
      maxIdx = rightIdx;
    }

    if (maxIdx != p) {
      swap(a, p, maxIdx);
      siftDown(a, maxIdx, n);
    }
  }

  private static int left(int p) { return 2 * p + 1; }

  private static int right(int p) { return 2 * p + 2; }

  public static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}