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

        knapsack(profits, weights, capacity);
      }
    }
  }

  // O(2^n) / O(W)
  public static void knapsack(int[] profits, int[] weights, int capacity) {
    List<Integer> items = new ArrayList<>();
    int totalProfit =
        knapsack(profits, weights, capacity, 0, new ArrayList<>(), items);

    System.out.println(totalProfit);
    for (int item : items) {
      System.out.printf("%d ", weights[item]);
    }
    System.out.println();
  }

  private static int knapsack(int[] profits, int[] weights, int capacity,
                              int currIdx, List<Integer> currItems,
                              List<Integer> items) {
    if (capacity <= 0 || currIdx >= profits.length) {
      int currProfit = 0, maxProfit = 0;

      for (int idx : currItems) {
        currProfit += profits[idx];
      }

      for (int idx : items) {
        maxProfit += profits[idx];
      }

      if (currProfit > maxProfit) {
        items.clear();
        for (int idx : currItems) {
          items.add(idx);
        }
      }

      return 0;
    }

    int profit1 = 0, profit2 = 0;

    if (weights[currIdx] <= capacity) {
      currItems.add(currIdx);
      profit1 = profits[currIdx] + knapsack(profits, weights,
                                            capacity - weights[currIdx],
                                            currIdx + 1, currItems, items);
    }

    if (weights[currIdx] <= capacity) {
      currItems.remove(currItems.size() - 1);
    }

    profit2 =
        knapsack(profits, weights, capacity, currIdx + 1, currItems, items);

    return Math.max(profit1, profit2);
  }
}