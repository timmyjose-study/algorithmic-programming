import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NCKMemo {
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
  public static int nck(int n, int k) {
    Integer[][] dp = new Integer[n + 1][k + 1];
    return nck(n, k, dp);
  }

  private static int nck(int n, int k, Integer[][] dp) {
    if (k == 0 || n == k) {
      return 1;
    }

    if (dp[n][k] != null) {
      return dp[n][k];
    }

    dp[n][k] = nck(n - 1, k - 1, dp) + nck(n - 1, k, dp);

    return dp[n][k];
  }
}