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

  // O(ns) / O(ns)
  public static boolean canPartition(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }

    if (sum % 2 != 0 || a.length == 0) {
      return false;
    }

    Boolean[][] dp = new Boolean[a.length][sum / 2 + 1];

    return canPartition(a, sum / 2, dp, 0);
  }

  private static boolean canPartition(int[] a, int sum, Boolean[][] dp,
                                      int currIdx) {
    if (sum == 0) {
      return true;
    }

    if (currIdx >= a.length) {
      return false;
    }

    if (dp[currIdx][sum] != null) {
      return dp[currIdx][sum];
    }

    dp[currIdx][sum] = canPartition(a, sum, dp, currIdx + 1);

    if (a[currIdx] <= sum) {
      dp[currIdx][sum] = dp[currIdx][sum] ||
                         canPartition(a, sum - a[currIdx], dp, currIdx + 1);
    }

    return dp[currIdx][sum];
  }
}