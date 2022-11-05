import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SlidingWindowMedian {
  static class MedianOfStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    MedianOfStream() {
      this.minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
      this.maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    }

    // O(logn) / O(n)
    public void insertNum(int num) {
      if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
        maxHeap.add(num);
      } else {
        minHeap.add(num);
      }

      rebalance();
    }

    private void rebalance() {
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.add(maxHeap.poll());
      } else if (minHeap.size() > maxHeap.size()) {
        maxHeap.add(minHeap.poll());
      }
    }

    // O(1) / O(1)
    public double findMedian() {
      if (maxHeap.size() == minHeap.size()) {
        return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
      }
      return maxHeap.peek();
    }

    // O(n) / O(1)
    public void removeNum(int num) {
      if (num <= maxHeap.peek()) {
        maxHeap.remove(num);
      } else if (num >= minHeap.peek()) {
        minHeap.remove(num);
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

        var res = findSlidingWindowMedian(mos, a, n, k);
        for (double r : res) {
          System.out.printf("%.1f ", r);
        }
        System.out.println();
      }
    }
  }

  // O(nk) / O(k)
  public static double[] findSlidingWindowMedian(MedianOfStream mos, int[] a,
                                                 int n, int k) {
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

    return res;
  }
}