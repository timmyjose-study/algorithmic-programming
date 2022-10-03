import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class MaximumSumSubarrayOfSizeK {
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

        int maxSum = 0, currSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          currSum += a[windowEnd];

          if (windowEnd >= k - 1) {
            maxSum = Math.max(maxSum, currSum);
            currSum -= a[windowStart];
            windowStart++;
          }
        }

        System.out.println(maxSum);
      }
    }
  }
}