import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KnapsackMemo {
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

        System.out.println(knapsack(profits, weights, capacity));
      }
    }
  }

  // O(nc) / O(nc)
  public static int knapsack(int[] profits, int[] weights, int capacity) {
    if (capacity <= 0 || profits.length == 0 ||
        profits.length != weights.length) {
      return 0;
    }

    int[][] memo = new int[profits.length][capacity + 1];
    return knapsack(profits, weights, capacity, 0, memo);
  }

  private static int knapsack(int[] profits, int[] weights, int capacity,
                              int currIdx, int[][] memo) {
    if (currIdx >= profits.length || capacity <= 0) {
      return 0;
    }

    if (memo[currIdx][capacity] != 0) {
      return memo[currIdx][capacity];
    }

    int profit1 = 0;
    if (weights[currIdx] <= capacity) {
      profit1 = profits[currIdx] + knapsack(profits, weights,
                                            capacity - weights[currIdx],
                                            currIdx + 1, memo);
    }

    int profit2 = knapsack(profits, weights, capacity, currIdx + 1, memo);
    memo[currIdx][capacity] = Math.max(profit1, profit2);

    return memo[currIdx][capacity];
  }
}