import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class RodCuttingBrute {
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

        System.out.println(rodCutting(prices, lengths, l));
      }
    }
  }

  // O(2n) / O(2n)
  public static int rodCutting(int[] prices, int[] lengths, int length) {
    if (lengths.length == 0 || length == 0) {
      return 0;
    }

    return rodCutting(prices, lengths, length, 0);
  }

  private static int rodCutting(int[] prices, int[] lengths, int length,
                                int currIdx) {
    if (currIdx >= lengths.length) {
      return 0;
    }

    int profit1 = 0;

    if (lengths[currIdx] <= length) {
      profit1 = prices[currIdx] +
                rodCutting(prices, lengths, length - lengths[currIdx], currIdx);
    }

    int profit2 = rodCutting(prices, lengths, length, currIdx + 1);

    return Math.max(profit1, profit2);
  }
}