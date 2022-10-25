import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nk) / O(k)
public class SlidingWindowMedian {
  static class MedianofStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    MedianofStream() {
      this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
      this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }

    // O(logn)
    public void insertNum(int n) {
      if (maxHeap.isEmpty() || maxHeap.peek() >= n) {
        maxHeap.add(n);
      } else {
        minHeap.add(n);
      }

      rebalance();
    }

    private void rebalance() {
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.add(maxHeap.poll());
      } else if (maxHeap.size() < minHeap.size()) {
        maxHeap.add(minHeap.poll());
      }
    }

    // O(1)
    public double findMedian() {
      if (maxHeap.isEmpty()) {
        throw new IllegalStateException("max heap empty");
      }

      if (maxHeap.size() == minHeap.size()) {
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
      }

      return maxHeap.peek();
    }

    // O(n)
    public void removeNum(int n) {
      if (!maxHeap.isEmpty() && maxHeap.peek() >= n) {
        maxHeap.remove(n);
      } else if (!minHeap.isEmpty()) {
        minHeap.remove(n);
      }

      rebalance();
    }
  }

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

        MedianofStream mos = new MedianofStream();

        double[] res = new double[n - k + 1];
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          mos.insertNum(a[windowEnd]);

          if (windowEnd >= k - 1) {
            res[windowStart] = mos.findMedian();
            mos.removeNum(a[windowStart]);
            windowStart++;
          }
        }

        for (double d : res) {
          System.out.printf("%.1f ", d);
        }
        System.out.println();
      }
    }
  }
}