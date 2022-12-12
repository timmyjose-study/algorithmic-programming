import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class StaircaseOptimal {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(numWays(n));
      }
    }
  }

  // O(n) / O(1)
  public static int numWays(int n) {
    int a = 1, b = 1, c = 2, d = 0;

    if (n == 0) {
      return a;
    }

    if (n == 1) {
      return b;
    }

    if (n == 2) {
      return c;
    }

    for (int i = 3; i < n; i++) {
      d = a + b + c;
      a = b;
      b = c;
      c = d;
    }

    return a + b + c;
  }
}