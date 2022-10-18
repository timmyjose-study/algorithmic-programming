import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NextPermutation {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        Arrays.sort(a);

        do {
          for (int e : a) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        } while (nextPermutation(a));
      }
    }
  }

  // O(n) / O(1)
  private static boolean nextPermutation(int[] a) {
    int invPos = -1;
    for (int i = a.length - 1; i > 0; i--) {
      if (a[i] > a[i - 1]) {
        invPos = i - 1;
        break;
      }
    }

    if (invPos == -1) {
      return false;
    }

    int nextPos = nextGreater(a, invPos, a.length - 1);
    swap(a, invPos, nextPos);
    reverse(a, invPos + 1, a.length - 1);

    return true;
  }

  private static int nextGreater(int[] a, int invPos, int n) {
    for (int i = n; i > invPos; i--) {
      if (a[i] > a[invPos]) {
        return i;
      }
    }

    return -1;
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static void reverse(int[] a, int from, int to) {
    for (int i = from, j = to; i < j; i++, j--) {
      swap(a, i, j);
    }
  }
}