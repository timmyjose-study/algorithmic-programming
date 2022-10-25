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

  private static void sort(int[] a, int n) {
    buildHeap(a, n);

    int len = n;
    for (int i = 0; i < n; i++) {
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

  private static void siftDown(int[] a, int pos, int n) {
    int minIdx = pos;

    int leftIdx = left(pos);
    if (leftIdx < n && a[leftIdx] > a[minIdx]) {
      minIdx = leftIdx;
    }

    int rightIdx = right(pos);
    if (rightIdx < n && a[rightIdx] > a[minIdx]) {
      minIdx = rightIdx;
    }

    if (pos != minIdx) {
      swap(a, pos, minIdx);
      siftDown(a, minIdx, n);
    }
  }

  private static int left(int p) { return 2 * p + 1; }
  private static int right(int p) { return 2 * p + 2; }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}