import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class DutchNationalFlag {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        sort(a, 0, n - 1);

        for (int e : a) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }

  private static void sort(int[] a, int low, int high) {
    int i = 0;

    while (i <= high) {
      if (a[i] == 0) {
        swap(a, i, low);
        i++;
        low++;
      } else if (a[i] == 1) {
        i++;
      } else {
        swap(a, i, high);
        high--;
      }
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}