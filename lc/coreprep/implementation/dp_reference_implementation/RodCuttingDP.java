import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class RodCuttingDP {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int l = in.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
          prices[i] = in.nextInt();
        }

        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
          lengths[i] = in.nextInt();
        }

        rodCutting(prices, lengths, l);
      }
    }
  }

  // O(nl) / O(nl)
  public static void rodCutting(int[] prices, int[] lengths, int length) {
    if (lengths.length == 0 || length == 0) {
      System.out.println(0);
      return;
    }

    int[][] dp = new int[lengths.length][length + 1];

    for (int i = 0; i < lengths.length; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i < lengths.length; i++) {
      for (int l = 0; l <= length; l++) {
        int profit1 = 0;

        if (lengths[i] <= l) {
          profit1 = prices[i] + dp[i][l - lengths[i]];
        }

        int profit2 = 0;

        if (i > 0) {
          profit2 = dp[i - 1][l];
        }

        dp[i][l] = Math.max(profit1, profit2);
      }
    }

    System.out.println(dp[lengths.length - 1][length]);
    printSelectedItems(prices, lengths, length, dp);
  }

  // O(n) / O(1)
  private static void printSelectedItems(int[] prices, int[] lengths,
                                         int length, int[][] dp) {
    int profit = dp[lengths.length - 1][length];

    List<Integer> items = new ArrayList<>();
    for (int i = lengths.length - 1; i > 0; i--) {
      if (dp[i][length] != dp[i - 1][length]) {
        items.add(lengths[i]);
        length -= lengths[i];
        profit -= prices[i];
      }
    }

    if (profit != 0) {
      items.add(lengths[0]);
    }

    for (int item : items) {
      System.out.printf("%d ", item);
    }
    System.out.println();
  }
}