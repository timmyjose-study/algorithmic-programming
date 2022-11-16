import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FibonacciDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(fibonacci(n));
      }
    }
  }

  // O(n) / O(n)
  public static long fibonacci(int n) {
    if (n < 2) {
      return n;
    }

    long[] dp = new long[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}