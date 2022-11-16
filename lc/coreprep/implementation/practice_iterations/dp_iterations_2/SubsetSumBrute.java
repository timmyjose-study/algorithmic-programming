import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SubsetSumBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(hasSubset(a, s));
      }
    }
  }

  // O(2n) / O(n)
  public static boolean hasSubset(int[] a, int sum) {
    if (a.length == 0) {
      return false;
    }

    return hasSubset(a, sum, 0);
  }

  private static boolean hasSubset(int[] a, int sum, int currIdx) {
    if (sum == 0) {
      return true;
    }

    if (currIdx >= a.length) {
      return false;
    }

    boolean has1 = false;

    if (a[currIdx] <= sum) {
      has1 = hasSubset(a, sum - a[currIdx], currIdx + 1);
    }

    return has1 || hasSubset(a, sum, currIdx + 1);
  }
}