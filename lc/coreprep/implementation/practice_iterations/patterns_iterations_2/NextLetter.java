import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NextLetter {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.next();
        char k = in.next().charAt(0);

        System.out.println(nextLetter(s, 0, s.length() - 1, k));
      }
    }
  }

  // O(logn) / O(1)
  public static char nextLetter(String s, int low, int high, char k) {
    if (k < s.charAt(low) || k > s.charAt(high)) {
      return s.charAt(low);
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (s.charAt(mid) <= k) {
        low = mid + 1;
      } else if (s.charAt(mid) > k) {
        high = mid - 1;
      }
    }

    return s.charAt(low % s.length());
  }
}