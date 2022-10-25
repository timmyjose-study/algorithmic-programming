import java.util.*;

public class LowerBound {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a);
      Arrays.sort(a);
      display(a);

      while (nq-- > 0) {
        int elem = in.nextInt();
        System.out.printf("%d\n%d\n", lowerBound(a, 0, n - 1, elem),
                          lowerBoundRec(a, 0, n - 1, elem));
      }
    }
  }

  public static int lowerBound(int[] a, int low, int high, int elem) {
    while (low < high) {
      int mid = low + (high - low) / 2;

      if (a[mid] < elem) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return a[low] >= elem ? low : a.length;
  }

  public static int lowerBoundRec(int[] a, int low, int high, int elem) {
    if (low >= high) {
      return a[low] >= elem ? low : a.length;
    }

    int mid = low + (high - low) / 2;
    if (a[mid] < elem) {
      return lowerBoundRec(a, mid + 1, high, elem);
    }
    return lowerBoundRec(a, low, mid, elem);
  }

  private static void display(int[] a) {
    for (int e : a) {
      System.out.printf("%d ", e);
    }
    System.out.println();
  }
}