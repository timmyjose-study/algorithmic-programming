import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NCKMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(nck(n, k));
      }
    }
  }

  // O(nk) / O(nk)
  public static long nck(int n, int k) {
    long[][] memo = new long[n + 1][n + 1];
    return nck(memo, n, k);
  }

  private static long nck(long[][] memo, int n, int k) {
    if (k == 0 || k == n) {
      return 1;
    }

    if (memo[n][k] != 0) {
      return memo[n][k];
    }

    memo[n][k] = nck(memo, n - 1, k - 1) + nck(memo, n - 1, k);

    return memo[n][k];
  }
}