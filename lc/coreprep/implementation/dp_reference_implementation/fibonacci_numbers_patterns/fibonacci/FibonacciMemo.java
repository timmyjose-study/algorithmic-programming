import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FibonacciMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(fib(n));
      }
    }
  }

  // O(n) / O(n)
  public static long fib(int n) {
    long[] memo = new long[n + 1];
    return fib(memo, n);
  }

  private static long fib(long[] memo, int n) {
    if (n < 2) {
      return n;
    }

    if (memo[n] != 0) {
      return memo[n];
    }

    memo[n] = fib(memo, n - 1) + fib(memo, n - 2);

    return memo[n];
  }
}