import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MedianOfNumberStream {
  private PriorityQueue<Integer> maxHeap;
  private PriorityQueue<Integer> minHeap;

  public MedianOfNumberStream() {
    this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
  }

  // O(logn)
  private void insertNum(int n) {
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
  private double findMedian() {
    if (maxHeap.isEmpty()) {
      throw new IllegalStateException("max heap empty");
    }

    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    return maxHeap.peek();
  }

  // O(n)
  private void removeNum(int n) {
    if (!maxHeap.isEmpty() && maxHeap.peek() >= n) {
      maxHeap.remove(n);
    } else if (!minHeap.isEmpty()) {
      minHeap.remove(n);
    }

    rebalance();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();
        MedianOfNumberStream mos = new MedianOfNumberStream();

        for (int i = 0; i < n; i++) {
          String[] cmd = in.nextLine().split(" ");

          if (cmd.length == 2 && cmd[0].equalsIgnoreCase("insert")) {
            mos.insertNum(Integer.parseInt(cmd[1]));
          } else {
            System.out.printf("%.1f\n", mos.findMedian());
          }
        }
      }
    }
  }
}