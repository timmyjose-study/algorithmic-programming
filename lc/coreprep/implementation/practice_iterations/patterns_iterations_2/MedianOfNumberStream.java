import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MedianOfNumberStream {
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
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int nq = in.nextInt();
        in.nextLine();

        MedianOfStream mos = new MedianOfStream();
        while (nq-- > 0) {
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