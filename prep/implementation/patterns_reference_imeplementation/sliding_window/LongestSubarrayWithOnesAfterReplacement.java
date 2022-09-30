import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class LongestSubarrayWithOnesAfterReplacement {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int maxOnesCount = 0, maxLen = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          if (a[windowEnd] == 1) {
            maxOnesCount++;
          }

          while (windowEnd - windowStart + 1 - maxOnesCount > k) {
            if (a[windowStart] == 1) {
              maxOnesCount--;
            }
            windowStart++;
          }

          maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        System.out.println(maxLen);
      }
    }
  }
}