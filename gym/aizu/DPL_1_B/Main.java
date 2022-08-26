import java.util.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int w = in.nextInt();
      int[] vs = new int[n];
      int[] ws = new int[n];

      for (int i = 0; i < n; i++) {
        vs[i] = in.nextInt();
        ws[i] = in.nextInt();
      }

      System.out.println(knapSack(ws, vs, w));
    }
  }

  private static int knapSack(int[] weights, int[] values, int capacity) {
    int[][] dp = new int[weights.length][capacity + 1];

    for (int i = 0; i <= capacity; i++) {
      if (weights[0] <= i) {
        dp[0][i] = values[0];
      }
    }

    for (int i = 1; i < weights.length; i++) {
      for (int j = 1; j <= capacity; j++) {
        if (weights[i] <= j) {
          dp[i][j] =
              Math.max(dp[i - 1][j], values[i] + dp[i - 1][j - weights[i]]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[weights.length - 1][capacity];
  }
}