import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class EqualSubsetSumPartitionDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(canPartition(a));
      }
    }
  }

  // O(ns) / O(ns)
  public static boolean canPartition(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }

    if (sum % 2 != 0 || a.length == 0) {
      return false;
    }

    boolean[][] dp = new boolean[a.length][sum / 2 + 1];

    for (int i = 0; i < a.length; i++) {
      dp[i][0] = true;
    }

    for (int s = 0; s <= sum / 2; s++) {
      if (a[0] == s) {
        dp[0][s] = true;
      }
    }

    for (int i = 1; i < a.length; i++) {
      for (int s = 1; s <= sum / 2; s++) {
        dp[i][s] = dp[i - 1][s];

        if (a[i] <= s) {
          dp[i][s] = dp[i][s] || dp[i - 1][s - a[i]];
        }
      }
    }

    if (dp[a.length - 1][sum / 2]) {
      printSubsets(a, sum / 2, dp);
      return true;
    }
    return false;
  }

  // O(n) / o(n)
  private static void printSubsets(int[] a, int sum, boolean[][] dp) {
    TreeSet<Integer> indices = new TreeSet<>();

    for (int i = a.length - 1; i > 0; i--) {
      if (dp[i][sum] != dp[i - 1][sum]) {
        indices.add(i);
        sum -= a[i];
      }
    }

    if (sum != 0) {
      indices.add(0);
    }

    for (int i = 0; i < a.length; i++) {
      if (indices.contains(i)) {
        System.out.printf("%d ", a[i]);
      }
    }
    System.out.println();

    for (int i = 0; i < a.length; i++) {
      if (!indices.contains(i)) {
        System.out.printf("%d ", a[i]);
      }
    }
    System.out.println();
  }
}