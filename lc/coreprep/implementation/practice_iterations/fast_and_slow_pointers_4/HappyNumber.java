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
    int fast = n, slow = n;

    do {
      fast = sumSquareDigits(sumSquareDigits(fast));
      slow = sumSquareDigits(slow);
    } while (fast != slow);

    return slow == 1;
  }

  private static int sumSquareDigits(int n) {
    int sum = 0;

    while (n > 0) {
      sum += (n % 10) * (n % 10);
      n /= 10;
    }

    return sum;
  }
}