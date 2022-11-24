import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CountOfSubsetSumDP {
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

  // O(ns) / O(s)
  public static int countSubsets(int[] a, int sum) {
    int[] dp = new int[sum + 1];
    dp[0] = 1;

    for (int s = 0; s <= sum; s++) {
      if (a[0] == s) {
        dp[s] = 1;
        break;
      }
    }

    for (int i = 1; i < a.length; i++) {
      for (int s = sum; s >= 0; s--) { // note direction
        if (a[i] <= s) {
          dp[s] += dp[s - a[i]]; // because of this
        }
      }
    }

    return dp[sum];
  }

  // O(ns) / O(ns)
  // public static int countSubsets(int[] a, int sum) {
  //   int[][] dp = new int[a.length][sum + 1];

  //   for (int i = 0; i < a.length; i++) {
  //     dp[i][0] = 1;
  //   }

  //   for (int s = 0; s <= sum; s++) {
  //     if (a[0] == s) {
  //       dp[0][s] = 1;
  //       break;
  //     }
  //   }

  //   for (int i = 1; i < a.length; i++) {
  //     for (int s = 1; s <= sum; s++) {
  //       dp[i][s] = dp[i - 1][s];

  //       if (a[i] <= s) {
  //         dp[i][s] += dp[i - 1][s - a[i]];
  //       }
  //     }
  //   }

  //   return dp[a.length - 1][sum];
  // }
}