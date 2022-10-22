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

        System.out.println(nextLetter(s.toCharArray(), k));
      }
    }
  }

  // O(logn) / O(1)
  public static char nextLetter(char[] a, char k) {
    int n = a.length;

    if (k < a[0] || k > a[n - 1]) {
      return a[0];
    }

    int low = 0, high = n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] <= k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return a[low % n];
  }
}