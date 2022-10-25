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

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }

  private static int parent(int idx) { return idx / 2; }
  private static int left(int idx) { return 2 * idx + 1; }
  private static int right(int idx) { return 2 * idx + 2; }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static void siftDown(int[] a, int idx, int n) {
    int maxIdx = idx;

    int leftIdx = left(idx);
    if (leftIdx < n && (a[maxIdx] < a[leftIdx])) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(idx);
    if (rightIdx < n && (a[maxIdx] < a[rightIdx])) {
      maxIdx = rightIdx;
    }

    if (maxIdx != idx) {
      swap(a, idx, maxIdx);
      siftDown(a, maxIdx, n);
    }
  }

  private static void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 0; i--) {
      siftDown(a, i, n);
    }
  }

  public static void sort(int[] a, int n) {
    buildHeap(a, n);

    while (n > 0) {
      swap(a, 0, n - 1);
      n--;
      siftDown(a, 0, n);
    }
  }
}