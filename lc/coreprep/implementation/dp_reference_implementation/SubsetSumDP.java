import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SubsetSumDP {
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

    boolean[][] dp = new boolean[a.length][sum + 1];

    for (int i = 0; i < a.length; i++) {
      dp[i][0] = true;
    }

    for (int s = 0; s <= sum; s++) {
      if (a[0] == s) {
        dp[0][s] = true;
      }
    }

    for (int i = 1; i < a.length; i++) {
      for (int s = 1; s <= sum; s++) {
        dp[i][s] = dp[i - 1][s];

        if (a[i] <= s) {
          dp[i][s] = dp[i][s] || dp[i - 1][s - a[i]];
        }
      }
    }

    if (dp[a.length - 1][sum]) {
      printSelectItems(a, sum, dp);
      return true;
    }
    return false;
  }

  // O(n) / O(1)
  private static void printSelectItems(int[] a, int sum, boolean[][] dp) {
    Set<Integer> indices = new HashSet<>();
    for (int i = a.length - 1; i > 0; i--) {
      if (dp[i][sum] != dp[i - 1][sum]) {
        indices.add(i);
        sum -= a[i];
      }
    }

    if (sum != 0) {
      indices.add(0);
    }

    List<Integer> items = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (indices.contains(i)) {
        items.add(a[i]);
      }
    }

    for (int item : items) {
      System.out.printf("%d ", item);
    }
    System.out.println();
  }
}