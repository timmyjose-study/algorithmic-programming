import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumSubsetSumDifferenceDP {
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

    boolean[][] dp = new boolean[a.length][sum / 2 + 1];

    for (int i = 0; i < a.length; i++) {
      dp[i][0] = true;
    }

    for (int s = 0; s <= sum / 2; s++) {
      if (a[0] == s) {
        dp[0][s] = true;
        break;
      }
    }

    for (int i = 1; i < a.length; i++) {
      for (int s = 1; s <= sum / 2; s++) {
        dp[i][s] = dp[i - 1][s];

        if (a[i] <= s) {
          dp[i][s] = dp[i][s] || dp[i - 1][s - a[i]];
        }
      }
    }

    int sum1 = 0;
    for (int i = sum / 2; i >= 0; i--) {
      if (dp[a.length - 1][i]) {
        sum1 = i;
        break;
      }
    }

    int sum2 = sum - sum1;
    return Math.abs(sum1 - sum2);
  }
}