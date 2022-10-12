import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
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

        int[] res = new int[n];
        int left = 0, right = n - 1;
        int nextPos = n - 1;

        while (left < right) {
          if (Math.abs(a[left]) >= Math.abs(a[right])) {
            res[nextPos--] = a[left] * a[left];
            left++;
          } else {
            res[nextPos--] = a[right] * a[right];
            right--;
          }
        }

        for (int e : res) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }
}