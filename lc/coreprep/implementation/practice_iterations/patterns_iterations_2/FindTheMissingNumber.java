import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FindTheMissingNumber {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(missingNumber(a));
      }
    }
  }

  // O(n) / O(1)
  public static int missingNumber(int[] a) {
    int i = 0;

    while (i < a.length) {
      if (a[i] >= a.length || a[i] == a[a[i]]) {
        i++;
      } else {
        swap(a, i, a[i]);
      }
    }

    for (int j = 0; j < a.length; j++) {
      if ((a[j] >= a.length) || (a[j] != a[a[j]])) {
        return j;
      }
    }

    return -1;
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}