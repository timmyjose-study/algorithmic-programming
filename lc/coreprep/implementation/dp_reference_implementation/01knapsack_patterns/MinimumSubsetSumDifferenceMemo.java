import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumSubsetSumDifferenceMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(minSubsetDiff(a));
      }
    }
  }

  // O(ns) / O(ns)
  public static int minSubsetDiff(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }

    Integer[][] dp = new Integer[a.length][sum + 1];

    return minSubsetDiff(a, 0, 0, dp, 0);
  }

  private static int minSubsetDiff(int[] a, int sum1, int sum2, Integer[][] dp,
                                   int currIdx) {
    if (currIdx == a.length) {
      return Math.abs(sum1 - sum2);
    }

    if (dp[currIdx][sum1] != null) {
      return dp[currIdx][sum1];
    }

    int diff1 = minSubsetDiff(a, sum1 + a[currIdx], sum2, dp, currIdx + 1);
    int diff2 = minSubsetDiff(a, sum1, sum2 + a[currIdx], dp, currIdx + 1);

    dp[currIdx][sum1] = Math.min(diff1, diff2);

    return dp[currIdx][sum1];
  }
}