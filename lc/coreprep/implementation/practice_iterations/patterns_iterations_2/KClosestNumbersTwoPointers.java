import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KClosestNumbersTwoPointers {
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

        var res = kClosestNumber(a, k, x);
        while (!res.isEmpty()) {
          System.out.printf("%d ", res.pollFirst());
        }
        System.out.println();
      }
    }
  }

  // O(logn + k) / O(1)
  public static Deque<Integer> kClosestNumber(int[] a, int k, int x) {
    int n = a.length;
    int pos = binarySearch(a, 0, n - 1, x);

    Deque<Integer> res = new ArrayDeque<>();
    int left = pos, right = pos + 1, cnt = 0;

    while (cnt < k) {
      if (left >= 0 && right < a.length) {
        if (Math.abs(x - a[left]) < Math.abs(x - a[right])) {
          res.addFirst(a[left]);
          left--;
        } else {
          res.addLast(a[right]);
          right++;
        }
      } else if (left >= 0) {
        res.addFirst(a[left]);
        left--;
      } else {
        res.addLast(a[right]);
        right++;
      }
      cnt++;
    }

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

    return (Math.abs(k - a[low]) < Math.abs(k - a[high])) ? low : high;
  }
}