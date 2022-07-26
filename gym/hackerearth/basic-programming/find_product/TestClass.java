import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class TestClass {
  private static final int MOD = 1_000_000_007;

  public static void main(String args[]) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      long prod = 1L;
      for (int i = 0; i < n; i++) {
        long d = in.nextLong();
        prod = (prod * (d % MOD)) % MOD;
      }

      System.out.printf("%d\n", prod);
    }
  }
}