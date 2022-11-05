import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
          profits[i] = in.nextInt();
        }

        System.out.println(maximizeCapital(capital, profits, n, k, c));
      }
    }
  }

  // O(nlogk + klogn) / O(n)
  public static int maximizeCapital(int[] capital, int[] profits, int n,
                                    int numProjects, int initialCapital) {
    PriorityQueue<Integer> minCapitalHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(capital[x], capital[y]));

    PriorityQueue<Integer> maxProfitHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(profits[y], profits[x]));

    for (int i = 0; i < n; i++) {
      minCapitalHeap.add(i);
    }

    int totalCapital = initialCapital;
    for (int i = 0; i < numProjects; i++) {
      while (!minCapitalHeap.isEmpty() &&
             (capital[minCapitalHeap.peek()] <= totalCapital)) {
        maxProfitHeap.add(minCapitalHeap.poll());
      }

      if (maxProfitHeap.isEmpty()) {
        break;
      }

      totalCapital += profits[maxProfitHeap.poll()];
    }

    return totalCapital;
  }
}