import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        System.out.println(duplicateNumber(a));
      }
    }
  }

  // O(n) / O(1)
  public static int duplicateNumber(int[] a) {
    int i = 0;

    while (i < a.length) {
      if (a[i] != a[a[i] - 1]) {
        swap(a, i, a[i] - 1);
      } else {
        i++;
      }
    }

    for (int j = 0; j < a.length; j++) {
      if (a[j] != j + 1) {
        return a[j];
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