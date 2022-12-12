import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumNumberOfJumpsMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(minJumps(a));
      }
    }
  }

  // O(n2) / O(n)
  public static int minJumps(int[] a) {
    Integer[] dp = new Integer[a.length];
    return minJumps(a, dp, 0);
  }

  private static int minJumps(int[] a, Integer[] dp, int currIdx) {
    if (currIdx == a.length - 1) {
      return 0;
    }

    if (a[currIdx] == 0) {
      return Integer.MAX_VALUE;
    }

    if (dp[currIdx] == null) {
      int currMinJumps = Integer.MAX_VALUE;
      int start = currIdx + 1;
      int end = currIdx + a[currIdx];

      while (start < a.length && start <= end) {
        int nextMinJumps = minJumps(a, dp, start);

        if (nextMinJumps != Integer.MAX_VALUE) {
          dp[currIdx] = Math.min(currMinJumps, 1 + nextMinJumps);
        }
        start++;
      }
    }

    return dp[currIdx];
  }
}