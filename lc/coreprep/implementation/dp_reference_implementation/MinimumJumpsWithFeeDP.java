import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumJumpsWithFeeDP {
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
    int[] dp = new int[fees.length + 1];
    dp[0] = 0;
    dp[1] = fees[0];
    dp[2] = fees[0];
    dp[3] = fees[0];

    for (int i = 4; i < fees.length + 1; i++) {
      dp[i] =
          Math.min(fees[i - 1] + dp[i - 1],
                   Math.min(fees[i - 2] + dp[i - 2], fees[i - 3] + dp[i - 3]));
    }

    return dp[fees.length];
  }
}