import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KClosestNumbersHeap {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = kClosestNumbers(a, k, x);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(logn + klogk) / O(k)
  public static List<Integer> kClosestNumbers(int[] a, int k, int x) {
    int pos = binarySearch(a, 0, a.length - 1, x);
    int start = Math.max(0, pos - k);
    int end = Math.min(pos + k, a.length - 1);

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (p, q) -> Integer.compare(Math.abs(x - q), Math.abs(x - p)));

    for (int i = start; i <= end; i++) {
      if (maxHeap.isEmpty() || maxHeap.size() < k) {
        maxHeap.add(a[i]);
      } else if (Math.abs(x - a[i]) < Math.abs(x - maxHeap.peek())) {
        maxHeap.poll();
        maxHeap.add(a[i]);
      }
    }

    List<Integer> res = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
      res.add(maxHeap.poll());
    }

    Collections.sort(res);

    return res;
  }

  private static int binarySearch(int[] a, int low, int high, int k) {
    if (a[low] > k) {
      return low;
    }

    if (a[high] < k) {
      return high;
    }

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (a[mid] < k) {
        low = mid + 1;
      } else if (a[mid] > k) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    if (Math.abs(k - a[low]) < Math.abs(k - a[high])) {
      return low;
    }
    return high;
  }
}