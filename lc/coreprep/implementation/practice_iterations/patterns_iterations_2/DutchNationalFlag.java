import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        sort(a);
        for (int e : a) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }

  // O(n) / O(1)
  public static void sort(int[] a) {
    int i = 0, low = 0, high = a.length - 1;

    while (i <= high) {
      if (a[i] == 0) {
        swap(a, i, low);
        low++;
        i++;
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