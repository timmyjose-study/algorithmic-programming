import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FibonacciMemo {
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
    Long[] dp = new Long[n + 1];
    return fibonacci(n, dp);
  }

  private static long fibonacci(int n, Long[] dp) {
    if (n < 2) {
      return n;
    }

    if (dp[n] != null) {
      return dp[n];
    }

    dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);

    return dp[n];
  }
}