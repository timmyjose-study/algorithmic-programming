import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Floor {
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

        System.out.println(floor(a, k));
      }
    }
  }

  // O(logn) / O(1)
  public static int floor(int[] a, int k) {
    if (a[0] > k) {
      return -1;
    }

    int low = 0, high = a.length - 1;
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

    return high;
  }
}