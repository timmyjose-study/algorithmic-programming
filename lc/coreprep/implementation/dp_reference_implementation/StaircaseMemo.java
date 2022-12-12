import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class StaircaseMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(numWays(n));
      }
    }
  }

  // O(n) / O(n)
  public static int numWays(int n) {
    Integer[] dp = new Integer[n + 1];
    return numWays(n, dp);
  }

  private static int numWays(int n, Integer[] dp) {
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    if (dp[n] == null) {
      dp[n] = numWays(n - 1, dp) + numWays(n - 2, dp) + numWays(n - 3, dp);
    }

    return dp[n];
  }
}