import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaximumDistinctElements {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(maximumDistinctElements(a, k));
      }
    }
  }

  // O(nlogn) / O(n)
  public static int maximumDistinctElements(int[] a, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int e : a) {
      freq.put(e, freq.getOrDefault(e, 0) + 1);
    }

    int res = 0;
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        (x, y) -> Integer.compare(x.getValue(), y.getValue()));

    for (var entry : freq.entrySet()) {
      if (entry.getValue() == 1) {
        res++;
      } else {
        minHeap.add(entry);
      }
    }

    while (!minHeap.isEmpty() && k > 0) {
      var entry = minHeap.poll();

      int d = entry.getValue() - 1;
      if (d > 0 && d <= k) {
        k -= d;
        res++;
      } else {
        k--;
      }
    }

    res -= k;

    return res;
  }
}