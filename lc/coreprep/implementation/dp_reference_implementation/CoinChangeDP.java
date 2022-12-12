import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CoinChangeDP {
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

  // O(na) / O(na)
  public static int numWays(int amount, int[] coins) {
    if (amount == 0 || coins.length == 0) {
      return 1;
    }

    int[][] dp = new int[coins.length][amount + 1];

    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < coins.length; i++) {
      for (int a = 1; a <= amount; a++) {
        int ways1 = 0;

        if (coins[i] <= a) {
          ways1 = dp[i][a - coins[i]];
        }

        int ways2 = 0;

        if (i > 0) {
          ways2 = dp[i - 1][a];
        }

        dp[i][a] = ways1 + ways2;
      }
    }

    return dp[coins.length - 1][amount];
  }
}