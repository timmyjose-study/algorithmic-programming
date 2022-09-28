import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n)
public class SmallestSubarrayWithGivenSum {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int sum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          sum += a[windowEnd];

          while (sum >= s) {
            minLength = Math.min(minLength, windowEnd - windowStart + 1);
            sum -= a[windowStart];
            windowStart++;
          }
        }

        System.out.println(minLength);
      }
    }
  }
}