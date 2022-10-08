import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class FindTheMissingNumber {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(findMissing(a));
      }
    }
  }

  private static int findMissing(int[] a) {
    int i = 0;
    while (i < a.length) {
      if (a[i] < a.length && a[i] != a[a[i]]) {
        swap(a, i, a[i]);
      } else {
        i++;
      }
    }

    int missing = -1;
    for (i = 0; i < a.length; i++) {
      if (a[i] != i) {
        missing = i;
        break;
      }
    }

    return missing;
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}