import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KnapsackBrute {
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

  // O(2n) / O(n)
  public static int knapsack(int[] profits, int[] weights, int capacity) {
    if (weights.length == 0 || capacity == 0) {
      return 0;
    }

    return knapsack(profits, weights, capacity, 0);
  }

  private static int knapsack(int[] profits, int[] weights, int capacity,
                              int currIdx) {
    if (currIdx >= weights.length) {
      return 0;
    }

    int profit1 = 0;
    if (weights[currIdx] <= capacity) {
      profit1 =
          profits[currIdx] +
          knapsack(profits, weights, capacity - weights[currIdx], currIdx);
    }

    int profit2 = knapsack(profits, weights, capacity, currIdx + 1);

    return Math.max(profit1, profit2);
  }
}