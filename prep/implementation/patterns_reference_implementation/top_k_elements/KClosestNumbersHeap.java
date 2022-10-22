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
    int n = a.length;

    int closestIdx = binarySearch(a, 0, n - 1, x);
    int low = Math.max(0, closestIdx - k);
    int high = Math.min(closestIdx + k, n - 1);

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        (p, q) -> Integer.compare(Math.abs(a[p] - x), Math.abs(a[q] - x)));

    for (int i = low; i <= high; i++) {
      minHeap.add(i);
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      res.add(a[minHeap.poll()]);
    }

    res.sort(Integer::compare);

    return res;
  }

  private static int binarySearch(int[] a, int low, int high, int k) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (a[mid] < k) {
        low = mid + 1;
      } else if (a[mid] > k) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    if (low > 0) {
      low--;
    }

    return low;
  }
}