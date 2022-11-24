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

        System.out.println(minDiff(a));
      }
    }
  }

  // O(ns) / O(ns)
  public static int minDiff(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }

    Integer[][] dp = new Integer[a.length][sum + 1];

    return minDiff(a, 0, 0, dp, 0);
  }

  private static int minDiff(int[] a, int sum1, int sum2, Integer[][] dp,
                             int currIdx) {
    if (currIdx == a.length) {
      return Math.abs(sum1 - sum2);
    }

    if (dp[currIdx][sum1] != null) {
      return dp[currIdx][sum1];
    }

    int diff1 = minDiff(a, sum1 + a[currIdx], sum2, dp, currIdx + 1);
    int diff2 = minDiff(a, sum1, sum2 + a[currIdx], dp, currIdx + 1);

    dp[currIdx][sum1] = Math.min(diff1, diff2);

    return dp[currIdx][sum1];
  }
}