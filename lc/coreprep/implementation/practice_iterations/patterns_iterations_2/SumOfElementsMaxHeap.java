import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SumOfElementsMaxHeap {
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

  // O(nlogk2) / O(k2)
  public static int sumOfElements(int[] a, int k1, int k2) {
    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    for (int i = 0; i < k2 - 1; i++) {
      maxHeap.add(a[i]);
    }

    for (int i = k2 - 1; i < a.length; i++) {
      if (a[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(a[i]);
      }
    }

    int sum = 0;
    for (int i = 0; i < k2 - k1 - 1; i++) {
      sum += maxHeap.poll();
    }

    return sum;
  }
}