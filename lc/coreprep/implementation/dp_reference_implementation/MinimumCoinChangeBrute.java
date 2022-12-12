import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumCoinChangeBrute {
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

  // O(2n) / O(n)
  public static int minChange(int amount, int[] coins) {
    if (amount == 0 || coins.length == 0) {
      return -1;
    }

    int res = minChange(amount, coins, 0);
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private static int minChange(int amount, int[] coins, int currIdx) {
    if (amount == 0) {
      return 0;
    }

    if (currIdx >= coins.length) {
      return Integer.MAX_VALUE;
    }

    int ways1 = Integer.MAX_VALUE;
    if (coins[currIdx] <= amount) {
      int res = minChange(amount - coins[currIdx], coins, currIdx);

      if (res != Integer.MAX_VALUE) {
        ways1 = 1 + res;
      }
    }

    int ways2 = minChange(amount, coins, currIdx + 1);

    return Math.min(ways1, ways2);
  }
}