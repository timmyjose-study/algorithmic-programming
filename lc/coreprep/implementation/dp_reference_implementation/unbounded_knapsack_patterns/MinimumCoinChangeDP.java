import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumCoinChangeDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int amount = in.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
          coins[i] = in.nextInt();
        }

        int res = minChange(amount, coins);
        System.out.println((res == Integer.MAX_VALUE ? -1 : res));
      }
    }
  }

  // O(na) / O(na)
  public static int minChange(int amount, int[] coins) {
    if (amount == 0 || coins.length == 0) {
      return -1;
    }

    int[][] dp = new int[coins.length][amount + 1];

    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i < coins.length; i++) {
      for (int a = 1; a <= amount; a++) {
        int ways1 = Integer.MAX_VALUE;

        if (coins[i] <= a) {
          int res = dp[i][a - coins[i]];

          if (res != Integer.MAX_VALUE) {
            ways1 = 1 + res;
          }
        }

        int ways2 = Integer.MAX_VALUE;
        if (i > 0) {
          ways2 = dp[i - 1][a];
        }

        dp[i][a] = Math.min(ways1, ways2);
      }
    }

    return dp[coins.length - 1][amount];
  }
}