import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class FindTheDuplicateNumber {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(findTheDuplicateNumber(a));
      }
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static int findTheDuplicateNumber(int[] a) {
    int i = 0;
    int n = a.length;

    while (i < n) {
      if (a[i] != i + 1) {
        if (a[i] != a[a[i] - 1]) {
          swap(a, i, a[i] - 1);
        } else {
          return a[i];
        }
      } else {
        i++;
      }
    }

    return -1;
  }
}