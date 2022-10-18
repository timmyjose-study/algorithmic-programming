import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class UpperBound {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a, n);
      Arrays.sort(a);
      display(a, n);

      while (nq-- > 0) {
        int elem = in.nextInt();
        System.out.printf("%d\n%d\n", upperBound(a, 0, n - 1, elem),
                          upperBoundRec(a, 0, n - 1, elem));
      }
    }
  }

  // O(logn)
  private static int upperBound(int[] a, int low, int high, int elem) {
    while (low < high) {
      int mid = low + (high - low) / 2;

      if (a[mid] <= elem) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return a[low] > elem ? low : a.length;
  }

  // O(logn)
  private static int upperBoundRec(int[] a, int low, int high, int elem) {
    if (low >= high) {
      return a[low] > elem ? low : a.length;
    }

    int mid = low + (high - low) / 2;

    if (a[mid] <= elem) {
      return upperBoundRec(a, mid + 1, high, elem);
    }
    return upperBoundRec(a, low, mid, elem);
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}