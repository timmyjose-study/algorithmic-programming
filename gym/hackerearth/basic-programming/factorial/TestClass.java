import java.util.*;
import java.util.function.*;

class TestClass {
  public static void main(String args[]) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      Function<Integer, Integer> factorial = (n) -> {
        int f = 1;
        for (int i = 2; i <= n; i++) {
          f *= i;
        }
        return f;
      };

      int n = in.nextInt();
      System.out.printf("%d\n", factorial.apply(n));
    }
  }
}