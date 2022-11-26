import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NumberFactorsBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(numFactors(n));
      }
    }
  }

  // O(3n) / O(n)
  public static int numFactors(int n) {
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 1;
    }

    if (n == 3) {
      return 2;
    }

    return numFactors(n - 1) + numFactors(n - 3) + numFactors(n - 4);
  }
}