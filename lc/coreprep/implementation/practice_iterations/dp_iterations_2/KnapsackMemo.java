import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KnapsackMemo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int c = in.nextInt();

        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
          profits[i] = in.nextInt();
        }

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
          weights[i] = in.nextInt();
        }

        System.out.println(knapsack(profits, weights, c));
      }
    }
  }

  // O(nc) / O(nc)
  public static int knapsack(int[] profits, int[] weights, int capacity) {
    if (profits.length == 0 || capacity == 0) {
      return 0;
    }

    Integer[][] dp = new Integer[weights.length][capacity + 1];
    return knapsack(profits, weights, capacity, dp, 0);
  }

  private static int knapsack(int[] profits, int[] weights, int capacity,
                              Integer[][] dp, int currIdx) {
    if (currIdx >= weights.length) {
      return 0;
    }

    if (dp[currIdx][capacity] != null) {
      return dp[currIdx][capacity];
    }

    int profit1 = 0;
    if (weights[currIdx] <= capacity) {
      profit1 = profits[currIdx] + knapsack(profits, weights,
                                            capacity - weights[currIdx], dp,
                                            currIdx + 1);
    }

    dp[currIdx][capacity] = Math.max(
        profit1, knapsack(profits, weights, capacity, dp, currIdx + 1));

    return dp[currIdx][capacity];
  }
}