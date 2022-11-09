import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MedianOfNumberStream {
  static class MedianOfStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    MedianOfStream() {
      this.maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
      this.minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
    }

    // O(logn) / O(1)
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

    private void removeNum(int n) {
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
        in.nextLine();

        MedianOfStream mos = new MedianOfStream();

        for (int i = 0; i < n; i++) {

          String[] cmd = in.nextLine().trim().split(" ");
          switch (cmd[0]) {
          case "insert":
            mos.insertNum(Integer.parseInt(cmd[1]));
            break;

          case "findmedian":
            System.out.printf("%.1f\n", mos.findMedian());
            break;
          }
        }
      }
    }
  }
}