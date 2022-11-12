import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NCKDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(nck(n, k));
      }
    }
  }

  // O(nk) / O(nk)
  public static long nck(int n, int k) {
    long[][] dp = new long[n + 1][n + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = dp[i][i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }

    return dp[n][k];
  }
}