import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KLargestNumbers {
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

        var res = kLargestNumbers(a, k);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(nlogk) / O(k)
  public static List<Integer> kLargestNumbers(int[] a, int k) {
    List<Integer> res = new ArrayList<>();

    PriorityQueue<Integer> minHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(x, y));

    for (int i = 0; i < k; i++) {
      minHeap.add(a[i]);
    }

    for (int i = k; i < a.length; i++) {
      if (a[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(a[i]);
      }
    }

    return new ArrayList<>(minHeap);
  }
}