import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NumberFactorsMemo {
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
    Integer[] dp = new Integer[n + 1];
    return numFactors(n, dp);
  }

  private static int numFactors(int n, Integer[] dp) {
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

    if (dp[n] == null) {
      dp[n] =
          numFactors(n - 1, dp) + numFactors(n - 3, dp) + numFactors(n - 4, dp);
    }

    return dp[n];
  }
}