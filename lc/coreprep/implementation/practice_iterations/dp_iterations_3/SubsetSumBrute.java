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

  public static boolean hasSubset(int[] a, int sum) {
    if (a.length == 0) {
      return false;
    }

    return hasSubset(a, sum, 0);
  }

  // O(2n) / o(n)
  private static boolean hasSubset(int[] a, int sum, int currIdx) {
    if (currIdx >= a.length) {
      return false;
    }

    if (sum == 0) {
      return true;
    }

    boolean has1 = false;

    if (a[currIdx] <= sum) {
      has1 = hasSubset(a, sum - a[currIdx], currIdx + 1);
    }

    boolean has2 = hasSubset(a, sum, currIdx + 1);

    return has1 || has2;
  }
}