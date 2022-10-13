import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nk) / O(k)
public class SlidingWindowMedian {
  static class MedianOfStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    MedianOfStream() {
      this.maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
      this.minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
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
      if (maxHeap.size() == minHeap.size()) {
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
      }
      return maxHeap.peek();
    }

    // O(n)
    public void removeNum(int n) {
      if (maxHeap.peek() >= n) {
        maxHeap.remove(n);
      } else {
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

        MedianOfStream mos = new MedianOfStream();

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