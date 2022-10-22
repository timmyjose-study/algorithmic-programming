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

        var res = kClosestNumbers(a, k, x);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(logn + k) / O(1)
  public static List<Integer> kClosestNumbers(int[] a, int k, int x) {
    int n = a.length;
    int closestIdx = binarySearch(a, 0, n - 1, x);

    List<Integer> res = new LinkedList<>();
    int left = closestIdx, right = closestIdx + 1;

    for (int i = 0; i < k; i++) {
      if (left >= 0 && right <= n - 1) {
        if (Math.abs(a[left] - x) < Math.abs(a[right] - x)) {
          res.add(0, a[left]);
          left--;
        } else {
          res.add(a[right]);
          right++;
        }
      } else if (left >= 0) {
        res.add(0, a[left]);
        left--;
      } else {
        res.add(a[right]);
        right++;
      }
    }

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