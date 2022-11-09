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

  // O(nlogn + klogn) / O(n)
  public static int maximumDistinctElements(int[] a, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int e : a) {
      freq.put(e, freq.getOrDefault(e, 0) + 1);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (x, y) -> Integer.compare(freq.get(y), freq.get(x)));

    int cnt = 0;
    for (var entry : freq.entrySet()) {
      if (entry.getValue() > 1) {
        maxHeap.add(entry.getKey());
      } else {
        cnt++;
      }
    }

    while (!maxHeap.isEmpty() && (k > 0)) {
      int d = maxHeap.poll();

      if (freq.get(d) - 1 <= k) {
        k -= freq.get(d) - 1;
        cnt++;
      }
    }

    if (k != 0) {
      cnt -= k;
    }

    return cnt;
  }
}