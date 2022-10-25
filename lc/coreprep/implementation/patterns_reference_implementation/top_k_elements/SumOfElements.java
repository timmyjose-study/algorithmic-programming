import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SumOfElements {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k1 = in.nextInt();
        int k2 = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(sumOfElements(a, k1, k2));
      }
    }
  }

  // O(nlogn) / O(n)
  public static int sumOfElements(int[] a, int k1, int k2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int e : a) {
      minHeap.add(e);
    }

    for (int i = 0; i < k1; i++) {
      minHeap.poll();
    }

    int res = 0;
    for (int i = 0; i < k2 - k1 - 1; i++) {
      res += minHeap.poll();
    }

    return res;
  }
}