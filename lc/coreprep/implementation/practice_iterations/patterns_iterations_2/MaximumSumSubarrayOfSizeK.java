import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        System.out.println(maximumSumSubarrayOfSizeK(a, k));
      }
    }
  }

  // O(n) / O(1)
  public static int maximumSumSubarrayOfSizeK(int[] a, int k) {
    int n = a.length;
    int maxSum = Integer.MIN_VALUE;
    int sum = 0, windowStart = 0;

    for (int windowEnd = 0; windowEnd < n; windowEnd++) {
      sum += a[windowEnd];

      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, sum);
        sum -= a[windowStart];
        windowStart++;
      }
    }

    return maxSum;
  }
}