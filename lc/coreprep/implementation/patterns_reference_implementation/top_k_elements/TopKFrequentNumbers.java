import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TopKFrequentNumbers {
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

        var res = topKFrequentNumbers(a, k);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(n + nlogk) / O(n)
  public static List<Integer> topKFrequentNumbers(int[] a, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int e : a) {
      freq.put(e, freq.getOrDefault(e, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        (x, y) -> Integer.compare(x.getValue(), y.getValue()));

    for (var entry : freq.entrySet()) {
      minHeap.add(entry);

      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      res.add(minHeap.poll().getKey());
    }

    return res;
  }
}