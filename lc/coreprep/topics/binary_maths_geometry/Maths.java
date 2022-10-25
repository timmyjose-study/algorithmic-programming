import java.util.function.BiFunction;
import java.util.function.Function;

public class Maths {
  public static void main(String[] args) {
    checkEvenOrOdd();
    sumOf1toN();
    sumOfGP();
    permutations();
    combinations();
  }

  private static void checkEvenOrOdd() {
    Function<Integer, Boolean> checker = (n) -> {
      if (n % 2 == 0) {
        return true;
      } else {
        return false;
      }
    };

    for (int i = 1; i <= 10; i++) {
      if (checker.apply(i)) {
        System.out.printf("%d is even\n", i);
      } else {
        System.out.printf("%d is odd\n", i);
      }
    }
  }

  private static void sumOf1toN() {
    for (int i = 1; i <= 10; i++) {
      System.out.printf("Sum of 1 to %d = %d\n", i, i * (i + 1) / 2);
    }
  }

  private static void sumOfGP() {
    for (int i = 1; i <= 10; i++) {
      System.out.printf("Sum of 2^0 to 2^%d = %d\n", i,
                        (int)Math.pow(2, i + 1) - 1);
    }
  }

  private static int factorial(int n) {
    int f = 1;
    for (int i = 2; i <= n; i++) {
      f *= i;
    }

    return f;
  }

  private static void permutations() {
    BiFunction<Integer, Integer, Integer> permute = (n, k) -> {
      return factorial(n) / factorial(n - k);
    };

    for (int i = 1; i <= 10; i++) {
      System.out.printf("10 permute %d = %d\n", i, permute.apply(10, i));
    }
  }

  private static void combinations() {
    BiFunction<Integer, Integer, Integer> choose = (n, k) -> {
      return factorial(n) / factorial(n - k) / factorial(k);
    };

    for (int i = 1; i <= 10; i++) {
      System.out.printf("10 choose %d = %d\n", i, choose.apply(10, i));
    }
  }
}