import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FibonacciOptimal {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(fib(n));
      }
    }
  }

  // O(n) / O(1)
  public static long fib(int n) {
    if (n < 2) {
      return n;
    }

    long a = 0, b = 1, c = 1;
    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }
}