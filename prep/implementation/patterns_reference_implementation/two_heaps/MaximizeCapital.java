import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn + klogn) / O(n)
public class MaximizeCapital {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int k = in.nextInt();
        int c = in.nextInt();

        int n = in.nextInt();
        int[] capital = new int[n];
        for (int i = 0; i < n; i++) {
          capital[i] = in.nextInt();
        }

        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
          profit[i] = in.nextInt();
        }

        System.out.println(maximizeCapital(capital, profit, k, c));
      }
    }
  }

  private static int maximizeCapital(int[] capital, int[] profit, int k,
                                     int c) {
    PriorityQueue<Integer> minCapitalHeap =
        new PriorityQueue<>((a, b) -> Integer.compare(capital[a], capital[b]));

    PriorityQueue<Integer> maxProfitHeap =
        new PriorityQueue<>((a, b) -> Integer.compare(profit[b], profit[a]));

    for (int i = 0; i < capital.length; i++) {
      minCapitalHeap.add(i);
    }

    int totalCapital = c;
    for (int i = 0; i < k; i++) {
      while (!minCapitalHeap.isEmpty() &&
             capital[minCapitalHeap.peek()] <= totalCapital) {
        maxProfitHeap.add(minCapitalHeap.poll());
      }

      if (maxProfitHeap.isEmpty()) {
        break;
      }

      totalCapital += profit[maxProfitHeap.poll()];
    }

    return totalCapital;
  }
}