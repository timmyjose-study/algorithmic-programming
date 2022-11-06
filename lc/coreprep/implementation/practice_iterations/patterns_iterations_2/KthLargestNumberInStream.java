import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthLargestNumberInStream {
  static class LargestInStream {
    PriorityQueue<Integer> minHeap;

    LargestInStream(int[] a, int k) {
      this.minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y));

      for (int i = 0; i < k; i++) {
        minHeap.add(a[i]);
      }

      for (int i = k; i < a.length; i++) {
        if (a[i] > minHeap.peek()) {
          minHeap.poll();
          minHeap.add(a[i]);
        }
      }
    }

    // O(logk) / O(k)
    public int add(int num) {
      if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(num);
      }

      return minHeap.peek();
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

        LargestInStream lis = new LargestInStream(a, k);

        int nq = in.nextInt();
        while (nq-- > 0) {
          int m = in.nextInt();
          System.out.println(lis.add(m));
        }
      }
    }
  }
}