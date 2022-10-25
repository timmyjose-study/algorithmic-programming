import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MedianOfNumberStream {
  private PriorityQueue<Integer> maxHeap;
  private PriorityQueue<Integer> minHeap;

  MedianOfNumberStream() {
    this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
  }

  public void insertNum(int n) {}

  public double findMedian() {}

  public void removeNum(int n) {}

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
    }
  }
}
