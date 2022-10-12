import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(logn) / O(1)
public class HappyNumber {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(isHappy(n));
      }
    }
  }

  private static boolean isHappy(int n) {
    Function<Integer, Integer> digitSquareSum = (Integer m) -> {
      int sum = 0;

      while (m > 0) {
        sum += (m % 10) * (m % 10);
        m /= 10;
      }
      return sum;
    };

    int fast = n, slow = n;
    do {
      fast = digitSquareSum.apply(digitSquareSum.apply(fast));
      slow = digitSquareSum.apply(slow);
    } while (fast != slow);

    return slow == 1;
  }
}