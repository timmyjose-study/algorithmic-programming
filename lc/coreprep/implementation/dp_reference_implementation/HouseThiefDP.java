import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class HouseThiefDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) {
          amounts[i] = in.nextInt();
        }

        System.out.println(maxAmount(amounts));
      }
    }
  }

  // O(n) / O(n)
  public static int maxAmount(int[] amounts) {
    int[] dp = new int[amounts.length + 1];
    dp[0] = 0;
    dp[1] = amounts[0];

    for (int i = 1; i < amounts.length; i++) {
      dp[i + 1] = Math.max(amounts[i] + dp[i - 1], dp[i]);
    }

    return dp[amounts.length];
  }
}