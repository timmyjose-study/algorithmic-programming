import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CoinChangeMemo {
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

        System.out.println(numWays(amount, coins));
      }
    }
  }

  // O(nc) / O(nc)
  public static int numWays(int amount, int[] coins) {
    if (amount == 0 || coins.length == 0) {
      return 1;
    }

    Integer[][] dp = new Integer[coins.length][amount + 1];
    return numWays(amount, coins, dp, 0);
  }

  private static int numWays(int amount, int[] coins, Integer[][] dp,
                             int currIdx) {
    if (amount == 0) {
      return 1;
    }

    if (currIdx >= coins.length) {
      return 0;
    }

    if (dp[currIdx][amount] == null) {
      int ways1 = 0;

      if (coins[currIdx] <= amount) {
        ways1 = numWays(amount - coins[currIdx], coins, dp, currIdx);
      }

      int ways2 = numWays(amount, coins, dp, currIdx + 1);

      dp[currIdx][amount] = ways1 + ways2;
    }

    return dp[currIdx][amount];
  }
}