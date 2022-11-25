import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaximumRibbonCutMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int length = in.nextInt();

        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
          lengths[i] = in.nextInt();
        }

        System.out.println(maxCuts(length, lengths));
      }
    }
  }

  // O(nl) / O(nl)
  public static int maxCuts(int length, int[] lengths) {
    if (length == 0 || lengths.length == 0) {
      return -1;
    }

    Integer[][] dp = new Integer[lengths.length][length + 1];
    int res = maxCuts(length, lengths, dp, 0);

    return res == Integer.MIN_VALUE ? -1 : res;
  }

  private static int maxCuts(int length, int[] lengths, Integer[][] dp,
                             int currIdx) {
    if (length == 0) {
      return 0;
    }

    if (currIdx >= lengths.length) {
      return Integer.MIN_VALUE;
    }

    if (dp[currIdx][length] == null) {
      int ways1 = Integer.MIN_VALUE;

      if (lengths[currIdx] <= length) {
        int res = maxCuts(length - lengths[currIdx], lengths, dp, currIdx);

        if (res != Integer.MIN_VALUE) {
          ways1 = 1 + res;
        }
      }

      int ways2 = maxCuts(length, lengths, dp, currIdx + 1);

      dp[currIdx][length] = Math.max(ways1, ways2);
    }

    return dp[currIdx][length];
  }
}