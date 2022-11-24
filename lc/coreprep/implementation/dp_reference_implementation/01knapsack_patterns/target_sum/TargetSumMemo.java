import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TargetSumMemo {
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

        System.out.println(countWays(a, s));
      }
    }
  }

  // O(ns) / O(ns)
  public static int countWays(int[] a, int sum) {
    int maxSum = 0;
    for (int e : a) {
      maxSum += e;
    }

    Integer[][] dp = new Integer[a.length][2 * maxSum + 1];
    return countWays(a, maxSum, sum, 0, dp, 0);
  }

  private static int countWays(int[] a, int maxSum, int sum, int currSum,
                               Integer[][] dp, int currIdx) {
    if (currIdx == a.length) {
      return sum == currSum ? 1 : 0;
    }

    if (currIdx >= a.length) {
      return 0;
    }

    if (dp[currIdx][currSum + maxSum] != null) {
      return dp[currIdx][currSum + maxSum];
    }

    dp[currIdx][currSum + maxSum] =
        countWays(a, maxSum, sum, currSum + a[currIdx], dp, currIdx + 1) +
        countWays(a, maxSum, sum, currSum - a[currIdx], dp, currIdx + 1);

    return dp[currIdx][currSum + maxSum];
  }
}