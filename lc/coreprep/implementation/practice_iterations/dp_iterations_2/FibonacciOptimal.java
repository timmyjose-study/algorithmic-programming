import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FibonacciOptimal {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(fibonacci(n));
      }
    }
  }

  // O(n) / O(1)
  public static long fibonacci(int n) {
    long a = 0, b = 1, c = 1;

    if (n == 0) {
      return a;
    }

    if (n == 1) {
      return b;
    }

    for (int i = 2; i < n; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return a + b;
  }
}