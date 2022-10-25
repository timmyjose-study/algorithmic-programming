import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumber {
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

        System.out.println(kthSmallestNumber(a, k));
      }
    }
  }

  // O(nlogk) / O(k)
  public static int kthSmallestNumber(int[] a, int k) {
    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    for (int i = 0; i < k; i++) {
      maxHeap.add(a[i]);
    }

    for (int i = k; i < a.length; i++) {
      if (a[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(a[i]);
      }
    }

    return maxHeap.peek();
  }
}