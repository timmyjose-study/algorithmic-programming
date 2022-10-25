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

        System.out.println(findDuplicate(a));
      }
    }
  }

  private static int findDuplicate(int[] a) {
    int i = 0;
    int duplicate = -1;

    while (i < a.length) {
      if (a[i] != i + 1) {
        if (a[i] != a[a[i] - 1]) {
          swap(a, i, a[i] - 1);
        } else {
          duplicate = a[i];
          break;
        }
      } else {
        i++;
      }
    }

    return duplicate;
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}