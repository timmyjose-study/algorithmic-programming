import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int amount = in.nextInt();
      int n = in.nextInt();
      int[] coins = new int[n];

      for (int i = 0; i < n; i++) {
        coins[i] = in.nextInt();
      }

      // validation
      int valid = 0;
      for (int coin : coins) {
        if (amount % coin == 0) {
          valid++;
        }
      }

      if (valid == 0) {
        System.out.println("No solution");
        return;
      }

      Arrays.sort(coins);

      for (int i = 0, j = n - 1; i < j; i++, j--) {
        int c = coins[i];
        coins[i] = coins[j];
        coins[j] = c;
      }

      System.out.printf("Amount = %d, Greedy = %d, Recursive = %d, DP = %d\n",
                        amount, greedyChange(amount, coins),
                        recursiveChange(amount, coins),
                        dpChange(amount, coins));
    }
  }

  private static int greedyChange(int amount, int[] coins) {
    int minChange = 0;

    while (amount > 0) {
      for (int coin : coins) {
        if (amount >= coin) {
          minChange++;
          amount -= coin;
          break;
        }
      }
    }

    return minChange;
  }

  private static int recursiveChange(int amount, int[] coins) {
    if (amount == 0) {
      return 0;
    }

    int minChange = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (amount >= coin) {
        minChange =
            Math.min(minChange, 1 + recursiveChange(amount - coin, coins));
      }
    }

    return minChange;
  }

  private static int dpChange(int amount, int[] coins) {
    int[] dp = new int[amount + 1];

    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;

      for (int coin : coins) {
        if (i >= coin) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        }
      }
    }

    return dp[amount];
  }
}