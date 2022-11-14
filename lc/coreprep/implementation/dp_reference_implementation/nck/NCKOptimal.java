import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NCKOptimal {
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

  // O(nk) / O(k)
  public static long nck(int n, int k) {
    long[] dp = new long[k + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(i, k); j > 0; j--) {
        dp[j] = dp[j] + dp[j - 1];
      }
    }

    return dp[k];
  }
}