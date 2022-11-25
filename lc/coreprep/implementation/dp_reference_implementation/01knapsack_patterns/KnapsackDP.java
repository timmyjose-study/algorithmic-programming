import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KnapsackDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int capacity = in.nextInt();

        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
          profits[i] = in.nextInt();
        }

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
          weights[i] = in.nextInt();
        }

        knapsack(profits, weights, capacity);
      }
    }
  }

  // O(nc) / O(nc)
  public static void knapsack(int[] profits, int[] weights, int capacity) {
    int[][] dp = new int[profits.length][capacity + 1];

    for (int i = 0; i < profits.length; i++) {
      dp[i][0] = 0;
    }

    for (int c = 0; c <= capacity; c++) {
      if (weights[0] <= c) {
        dp[0][c] = profits[0];
      }
    }

    for (int i = 1; i < profits.length; i++) {
      for (int c = 1; c <= capacity; c++) {
        dp[i][c] = dp[i - 1][c];

        if (weights[i] <= c) {
          dp[i][c] = Math.max(dp[i][c], profits[i] + dp[i - 1][c - weights[i]]);
        }
      }
    }

    System.out.println(dp[profits.length - 1][capacity]);
    printSelectedItems(profits, weights, capacity, dp);
  }

  private static void printSelectedItems(int[] profits, int[] weights,
                                         int capacity, int[][] dp) {
    List<Integer> items = new ArrayList<>();

    int profit = dp[profits.length - 1][capacity];
    for (int i = profits.length - 1; i > 0; i--) {
      if (profit != dp[i - 1][capacity]) {
        items.add(weights[i]);
        capacity -= weights[i];
        profit -= profits[i];
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