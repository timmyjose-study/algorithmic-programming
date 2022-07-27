import java.util.Arrays;
import java.util.Scanner;

public class LowerBound {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int q = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a, n);
      Arrays.sort(a);
      display(a, n);

      int elem, idx;
      for (int i = 0; i < q; i++) {
        elem = in.nextInt();

        idx = lowerBound(a, 0, n - 1, elem);

        if (idx == n) {
          System.out.printf("%d has no lower bound, index: %d\n", elem, idx);
        } else {
          System.out.printf("%d has a lower bound at index %d (elem %d)\n",
                            elem, idx, a[idx]);
        }
      }
    }
  }

  // O(logN)
  private static int lowerBound(int[] a, int low, int high, int elem) {
    int mid;

    while (low < high) {
      mid = low + (high - low) / 2;

      if (a[mid] < elem) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    if (a[low] >= elem) {
      return low;
    }

    return high + 1;
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}