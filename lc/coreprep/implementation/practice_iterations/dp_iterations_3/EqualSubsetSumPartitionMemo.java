import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class EqualSubsetSumPartitionMemo {
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

  // O(ns) / o(ns)
  public static boolean canPartition(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }

    if (sum % 2 != 0) {
      return false;
    }

    Boolean[][] dp = new Boolean[a.length][sum / 2 + 1];

    return canPartition(a, sum / 2, dp, 0);
  }

  private static boolean canPartition(int[] a, int sum, Boolean[][] dp,
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

    boolean can1 = false;

    if (a[currIdx] <= sum) {
      can1 = canPartition(a, sum - a[currIdx], dp, currIdx + 1);
    }

    boolean can2 = canPartition(a, sum, dp, currIdx + 1);

    dp[currIdx][sum] = can1 || can2;

    return dp[currIdx][sum];
  }
}