import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KnapsackBrute {
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

  // O(2n) / O(n)
  public static int knapsack(int[] profits, int[] weights, int capacity) {
    return knapsack(profits, weights, capacity, 0);
  }

  private static int knapsack(int[] profits, int[] weights, int capacity,
                              int currIdx) {
    if (currIdx >= profits.length || capacity <= 0) {
      return 0;
    }

    int profit1 = 0;
    if (weights[currIdx] <= capacity) {
      profit1 =
          profits[currIdx] +
          knapsack(profits, weights, capacity - weights[currIdx], currIdx + 1);
    }

    int profit2 = knapsack(profits, weights, capacity, currIdx + 1);

    return Math.max(profit1, profit2);
  }
}