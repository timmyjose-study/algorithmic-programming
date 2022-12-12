import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CoinChangeBrute {
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

  // O(2n) / O(n)
  public static int numWays(int amount, int[] coins) {
    if (amount == 0 || coins.length == 0) {
      return 1;
    }

    return numWays(amount, coins, 0);
  }

  private static int numWays(int amount, int[] coins, int currIdx) {
    if (amount == 0) {
      return 1;
    }

    if (currIdx >= coins.length) {
      return 0;
    }

    int ways1 = 0;

    if (coins[currIdx] <= amount) {
      ways1 = numWays(amount - coins[currIdx], coins, currIdx);
    }

    int ways2 = numWays(amount, coins, currIdx + 1);

    return ways1 + ways2;
  }
}