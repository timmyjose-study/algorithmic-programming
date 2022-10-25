import java.util.Scanner;

public class Factorial {
  private static final long MOD = (int)1e9 + 7;
  private static final int N = 1000000;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      long[] dp = new long[N];

      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i < N; i++) {
        dp[i] = ((i % MOD) * (dp[i - 1] % MOD)) % MOD;
      }

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(dp[n]);
      }
    }
  }
}