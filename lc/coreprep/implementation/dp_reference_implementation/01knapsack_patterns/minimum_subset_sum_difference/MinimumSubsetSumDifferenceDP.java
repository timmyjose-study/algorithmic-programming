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

    boolean[][] dp = new boolean[a.length][sum / 2 + 1];

    for (int i = 0; i < a.length; i++) {
      dp[i][0] = true;
    }

    for (int s = 0; s <= sum / 2; s++) {
      if (a[0] == s) {
        dp[0][s] = true;
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

    int pos = -1;
    for (int j = sum / 2; j >= 0; j--) {
      if (dp[a.length - 1][j]) {
        pos = j;
        break;
      }
    }

    int sum1 = pos;
    int sum2 = sum - sum1;

    return Math.abs(sum1 - sum2);
  }
}