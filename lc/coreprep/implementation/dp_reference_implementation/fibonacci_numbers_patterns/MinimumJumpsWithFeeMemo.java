import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumJumpsWithFeeMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] fees = new int[n];
        for (int i = 0; i < n; i++) {
          fees[i] = in.nextInt();
        }

        System.out.println(minFee(fees));
      }
    }
  }

  // O(n) / O(n)
  public static int minFee(int[] fees) {
    Integer[] dp = new Integer[fees.length + 1];
    return minFee(fees, dp, 0);
  }

  private static int minFee(int[] fees, Integer[] dp, int currIdx) {
    if (currIdx > fees.length - 1) {
      return 0;
    }

    if (dp[currIdx] == null) {
      dp[currIdx] =
          fees[currIdx] + Math.min(Math.min(minFee(fees, dp, currIdx + 1),
                                            minFee(fees, dp, currIdx + 2)),
                                   minFee(fees, dp, currIdx + 3));
    }

    return dp[currIdx];
  }
}