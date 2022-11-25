import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class RodCuttingMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int l = in.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
          prices[i] = in.nextInt();
        }

        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
          lengths[i] = in.nextInt();
        }

        System.out.println(rodCutting(prices, lengths, l));
      }
    }
  }

  // O(nl) / O(nl)
  public static int rodCutting(int[] prices, int[] lengths, int length) {
    if (lengths.length == 0 || length == 0) {
      return 0;
    }

    Integer[][] dp = new Integer[lengths.length][length + 1];
    return rodCutting(prices, lengths, length, dp, 0);
  }

  private static int rodCutting(int[] prices, int[] lengths, int length,
                                Integer[][] dp, int currIdx) {
    if (currIdx >= lengths.length) {
      return 0;
    }

    if (dp[currIdx][length] == null) {
      int profit1 = 0;

      if (lengths[currIdx] <= length) {
        profit1 =
            prices[currIdx] +
            rodCutting(prices, lengths, length - lengths[currIdx], dp, currIdx);
      }

      int profit2 = rodCutting(prices, lengths, length, dp, currIdx + 1);

      dp[currIdx][length] = Math.max(profit1, profit2);
    }

    return dp[currIdx][length];
  }
}