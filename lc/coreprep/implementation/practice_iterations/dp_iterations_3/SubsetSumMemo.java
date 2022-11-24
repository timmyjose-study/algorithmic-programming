import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SubsetSumMemo {
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

  // O(ns) / O(ns)
  public static boolean hasSubset(int[] a, int sum) {
    if (a.length == 0) {
      return false;
    }

    Boolean[][] dp = new Boolean[a.length][sum + 1];
    return hasSubset(a, sum, dp, 0);
  }

  private static boolean hasSubset(int[] a, int sum, Boolean[][] dp,
                                   int currIdx) {
    if (currIdx >= a.length) {
      return false;
    }

    if (sum == 0) {
      return true;
    }

    if (dp[currIdx][sum] != null) {
      return dp[currIdx][sum];
    }

    boolean has1 = false;

    if (a[currIdx] <= sum) {
      has1 = hasSubset(a, sum - a[currIdx], dp, currIdx + 1);
    }

    boolean has2 = hasSubset(a, sum, dp, currIdx + 1);

    dp[currIdx][sum] = has1 || has2;

    return dp[currIdx][sum];
  }
}