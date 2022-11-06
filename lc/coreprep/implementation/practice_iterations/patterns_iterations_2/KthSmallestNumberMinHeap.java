import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumberMinHeap {
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

        System.out.println(kthSmallest(a, k));
      }
    }
  }

  // O(nlogn + klogn) / O(1)
  public static int kthSmallest(int[] a, int k) {
    PriorityQueue<Integer> minHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(x, y));

    for (int e : a) {
      minHeap.add(e);
    }

    for (int i = 0; i < k - 1; i++) {
      minHeap.poll();
    }

    return minHeap.peek();
  }
}