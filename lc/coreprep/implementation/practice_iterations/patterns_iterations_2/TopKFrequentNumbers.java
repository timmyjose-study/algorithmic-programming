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

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        (p, q) -> Integer.compare(freq.get(p), freq.get(q)));

    int cnt = 0;
    for (var entry : freq.entrySet()) {
      if (minHeap.isEmpty() || minHeap.size() < k) {
        minHeap.add(entry.getKey());
      } else if (entry.getValue() > freq.get(minHeap.peek())) {
        minHeap.poll();
        minHeap.add(entry.getKey());
      }
    }

    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      res.add(minHeap.poll());
    }

    return res;
  }
}