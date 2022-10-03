import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
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

        int minLen = Integer.MAX_VALUE;
        int windowStart = 0, currSum = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          currSum += a[windowEnd];

          while (currSum >= s) {
            minLen = Math.min(minLen, windowEnd - windowStart + 1);
            currSum -= a[windowStart];
            windowStart++;
          }
        }

        System.out.println((minLen == Integer.MAX_VALUE ? 0 : minLen));
      }
    }
  }
}