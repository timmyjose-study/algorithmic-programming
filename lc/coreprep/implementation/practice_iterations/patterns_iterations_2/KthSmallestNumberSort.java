import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(1)
public class KthSmallestNumberSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        sort(a);
        System.out.printf("%d\n", a[k - 1]);
      }
    }
  }

  public static void sort(int[] a) {
    int n = a.length;
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

  private static void siftDown(int[] a, int p, int n) {
    int maxPos = p;

    int leftPos = left(p);
    if (leftPos < n && (a[leftPos] > a[maxPos])) {
      maxPos = leftPos;
    }

    int rightPos = right(p);
    if (rightPos < n && (a[rightPos] > a[maxPos])) {
      maxPos = rightPos;
    }

    if (maxPos != p) {
      swap(a, p, maxPos);
      siftDown(a, maxPos, n);
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static int left(int p) { return 2 * p + 1; }
  private static int right(int p) { return 2 * p + 2; }
}