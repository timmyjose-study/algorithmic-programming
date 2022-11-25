import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumCoinChangeMemo {
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

        System.out.println(minChange(amount, coins));
      }
    }
  }

  // O(na) / O(na)
  public static int minChange(int amount, int[] coins) {
    if (amount == 0 || coins.length == 0) {
      return -1;
    }

    Integer[][] dp = new Integer[coins.length][amount + 1];

    int res = minChange(amount, coins, dp, 0);
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private static int minChange(int amount, int[] coins, Integer[][] dp,
                               int currIdx) {
    if (amount == 0) {
      return 0;
    }

    if (currIdx >= coins.length) {
      return Integer.MAX_VALUE;
    }

    if (dp[currIdx][amount] == null) {
      int ways1 = Integer.MAX_VALUE;

      if (coins[currIdx] <= amount) {
        int res = minChange(amount - coins[currIdx], coins, dp, currIdx);

        if (res != Integer.MAX_VALUE) {
          ways1 = 1 + res;
        }
      }

      int ways2 = minChange(amount, coins, dp, currIdx + 1);

      dp[currIdx][amount] = Math.min(ways1, ways2);
    }

    return dp[currIdx][amount];
  }
}