import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class HouseThiefMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) {
          amounts[i] = in.nextInt();
        }

        System.out.println(maxAmount(amounts));
      }
    }
  }

  // o(n) / O(n)
  public static int maxAmount(int[] amounts) {
    Integer[] dp = new Integer[amounts.length];
    return maxAmount(amounts, dp, 0);
  }

  private static int maxAmount(int[] amounts, Integer[] dp, int currIdx) {
    if (currIdx >= amounts.length) {
      return 0;
    }

    if (dp[currIdx] == null) {
      int choose = amounts[currIdx] + maxAmount(amounts, dp, currIdx + 2);
      int notChoose = maxAmount(amounts, dp, currIdx + 1);

      dp[currIdx] = Math.max(choose, notChoose);
    }

    return dp[currIdx];
  }
}