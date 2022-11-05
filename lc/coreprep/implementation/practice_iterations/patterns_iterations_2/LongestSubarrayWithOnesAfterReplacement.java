import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        System.out.println(longestSubarrayWithOnesAfterReplacement(a, k));
      }
    }
  }

  // O(n) / O(1)
  public static int longestSubarrayWithOnesAfterReplacement(int[] a, int k) {
    int maxOnes = 0, maxLen = 0, windowStart = 0;

    for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
      if (a[windowEnd] == 1) {
        maxOnes++;
      }

      while (windowEnd - windowStart + 1 - maxOnes > k) {
        if (a[windowStart] == 1) {
          maxOnes--;
        }
        windowStart++;
      }
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }

    return maxLen;
  }
}