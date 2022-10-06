import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class Kadane {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < n; i++) {
          maxEndingHere += a[i];

          if (maxSoFar < maxEndingHere) {
            maxSoFar = maxEndingHere;
            start = s;
            end = i;
          }

          if (maxEndingHere < 0) {
            maxEndingHere = 0;
            s = i + 1;
          }
        }

        System.out.println(maxSoFar);
        while (start <= end) {
          System.out.printf("%d ", a[start++]);
        }
        System.out.println();
      }
    }
  }
}