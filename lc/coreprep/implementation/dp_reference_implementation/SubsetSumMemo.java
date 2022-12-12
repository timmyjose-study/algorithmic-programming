import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SubsetSumMemo {
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

        System.out.println(hasSubset(a, s));
      }
    }
  }

  // O(ns) / O(ns)
  public static boolean hasSubset(int[] a, int sum) {
    if (a.length == 0) {
      return false;
    }

    Boolean[][] dp = new Boolean[a.length][sum + 1];
    return hasSubset(a, sum, dp, 0);
  }

  private static boolean hasSubset(int[] a, int sum, Boolean[][] dp,
                                   int currIdx) {
    if (sum == 0) {
      return true;
    }

    if (currIdx >= a.length) {
      return false;
    }

    if (dp[currIdx][sum] != null) {
      return dp[currIdx][sum];
    }

    dp[currIdx][sum] = hasSubset(a, sum, dp, currIdx + 1);

    if (a[currIdx] <= sum) {
      dp[currIdx][sum] =
          dp[currIdx][sum] || hasSubset(a, sum - a[currIdx], dp, currIdx + 1);
    }

    return dp[currIdx][sum];
  }
}