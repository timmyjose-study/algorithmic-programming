import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CountOfSubsetSumMemo {
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

        System.out.println(countSubsets(a, s));
      }
    }
  }

  // O(ns) / O(ns)
  public static int countSubsets(int[] a, int sum) {
    Integer[][] dp = new Integer[a.length][sum + 1];
    return countSubsets(a, sum, 0, dp);
  }

  private static int countSubsets(int[] a, int sum, int currIdx,
                                  Integer[][] dp) {
    if (sum == 0) {
      return 1;
    }

    if (currIdx >= a.length) {
      return 0;
    }

    if (dp[currIdx][sum] != null) {
      return dp[currIdx][sum];
    }

    dp[currIdx][sum] = countSubsets(a, sum, currIdx + 1, dp);

    if (a[currIdx] <= sum) {
      dp[currIdx][sum] += countSubsets(a, sum - a[currIdx], currIdx + 1, dp);
    }

    return dp[currIdx][sum];
  }
}