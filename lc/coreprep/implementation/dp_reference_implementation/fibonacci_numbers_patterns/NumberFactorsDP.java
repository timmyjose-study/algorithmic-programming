import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NumberFactorsDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(numFactors(n));
      }
    }
  }

  // O(n) / O(n)
  public static int numFactors(int n) {
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 1;
    }

    if (n == 3) {
      return 2;
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;

    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
    }

    return dp[n];
  }
}