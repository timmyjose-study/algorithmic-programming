import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

  // O(logn) / O(1)
  public static boolean isHappy(int n) {
    int slow = n, fast = n;

    Function<Integer, Integer> sumSqrDigits = (m) -> {
      int s = 0;
      while (m > 0) {
        s += (m % 10) * (m % 10);
        m /= 10;
      }
      return s;
    };

    do {
      slow = sumSqrDigits.apply(slow);
      fast = sumSqrDigits.apply(sumSqrDigits.apply(fast));
    } while (slow != fast);

    return slow == 1;
  }
}