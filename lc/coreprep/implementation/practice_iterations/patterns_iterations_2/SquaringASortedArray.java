import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SquaringASortedArray {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = squareSortedArray(a);
        for (var r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(n) / O(n)
  public static int[] squareSortedArray(int[] a) {
    int[] res = new int[a.length];
    int nextPos = a.length - 1;
    int left = 0, right = a.length - 1;

    while (left < right) {
      int leftSqr = a[left] * a[left];
      int rightSqr = a[right] * a[right];

      if (leftSqr >= rightSqr) {
        res[nextPos--] = leftSqr;
        left++;
      } else {
        res[nextPos--] = rightSqr;
        right--;
      }
    }

    return res;
  }
}