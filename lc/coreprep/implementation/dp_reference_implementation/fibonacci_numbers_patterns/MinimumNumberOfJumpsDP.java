import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumNumberOfJumpsDP {
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
    int[] dp = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    dp[0] = 0;

    for (int start = 0; start < a.length - 1; start++) {
      for (int end = start + 1; end <= start + a[start] && end < a.length;
           end++) {
        dp[end] = Math.min(dp[end], dp[start] + 1);
      }
    }

    return dp[a.length - 1];
  }
}