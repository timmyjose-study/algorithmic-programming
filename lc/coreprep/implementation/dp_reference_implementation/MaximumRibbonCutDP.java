import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaximumRibbonCutDP {
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

    int[][] dp = new int[lengths.length][length + 1];

    for (int i = 0; i < lengths.length; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i < lengths.length; i++) {
      for (int l = 1; l <= length; l++) {
        int ways1 = Integer.MIN_VALUE;

        if (lengths[i] <= l) {
          int res = dp[i][l - lengths[i]];

          if (res != Integer.MIN_VALUE) {
            ways1 = 1 + res;
          }
        }

        int ways2 = Integer.MIN_VALUE;
        if (i > 0) {
          ways2 = dp[i - 1][l];
        }

        dp[i][l] = Math.max(ways1, ways2);
      }
    }

    return dp[lengths.length - 1][length] == Integer.MIN_VALUE
        ? -1
        : dp[lengths.length - 1][length];
  }
}