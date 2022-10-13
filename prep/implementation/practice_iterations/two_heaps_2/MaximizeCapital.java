import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn + klogn) / O(n)
public class MaximizeCapital {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int numProjects = in.nextInt();
        int initialCapital = in.nextInt();
        int n = in.nextInt();

        int[] capital = new int[n];
        for (int i = 0; i < n; i++) {
          capital[i] = in.nextInt();
        }

        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
          profit[i] = in.nextInt();
        }

        System.out.println(
            maximizeCapital(capital, profit, numProjects, initialCapital));
      }
    }
  }

  private static int maximizeCapital(int[] capital, int[] profit,
                                     int numProjects, int initialCapital) {
    PriorityQueue<Integer> minCapitalHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(capital[x], capital[y]));
    PriorityQueue<Integer> maxProfitHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(profit[y], profit[x]));

    int totalCapital = initialCapital;
    for (int i = 0; i < capital.length; i++) {
      minCapitalHeap.add(i);
    }

    for (int i = 0; i < numProjects; i++) {
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