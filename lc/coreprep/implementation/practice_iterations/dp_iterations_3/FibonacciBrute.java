import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FibonacciBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(fibonacci(n));
      }
    }
  }

  // O(2n) / O(n)
  public static int fibonacci(int n) {
    if (n < 2) {
      return n;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}