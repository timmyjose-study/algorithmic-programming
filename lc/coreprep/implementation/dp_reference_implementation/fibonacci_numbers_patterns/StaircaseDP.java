import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class StaircaseDP {
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
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    return dp[n];
  }
}