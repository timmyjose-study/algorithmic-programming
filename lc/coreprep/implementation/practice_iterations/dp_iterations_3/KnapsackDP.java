import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KnapsackDP {
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

        knapsack(profits, weights, c);
      }
    }
  }

  // O(nc) / O(nc)
  public static void knapsack(int[] profits, int[] weights, int capacity) {
    int[][] dp = new int[weights.length][capacity + 1];

    for (int i = 0; i < weights.length; i++) {
      dp[i][0] = 0;
    }

    for (int c = 0; c <= capacity; c++) {
      if (weights[0] <= c) {
        dp[0][c] = profits[0];
      }
    }

    for (int i = 1; i < weights.length; i++) {
      for (int c = 1; c <= capacity; c++) {
        dp[i][c] = dp[i - 1][c];

        if (weights[i] <= c) {
          dp[i][c] = Math.max(dp[i][c], profits[i] + dp[i - 1][c - weights[i]]);
        }
      }
    }

    System.out.println(dp[weights.length - 1][capacity]);
    printSelectedItems(profits, weights, capacity, dp);
  }

  // O(n) / O(n)
  private static void printSelectedItems(int[] profits, int[] weights,
                                         int capacity, int[][] dp) {
    List<Integer> items = new ArrayList<>();
    int profit = dp[weights.length - 1][capacity];

    for (int i = weights.length - 1; i > 0; i--) {
      if (dp[i][capacity] != dp[i - 1][capacity]) {
        items.add(weights[i]);
        profit -= profits[i];
        capacity -= weights[i];
      }
    }

    if (profit != 0) {
      items.add(weights[0]);
    }

    for (int item : items) {
      System.out.printf("%d ", item);
    }
    System.out.println();
  }
}