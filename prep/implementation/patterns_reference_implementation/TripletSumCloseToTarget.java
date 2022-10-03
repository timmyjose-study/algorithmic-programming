import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n^2) / O(n)
public class TripletSumCloseToTarget {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        Arrays.sort(a);

        int minDiff = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < n - 2; i++) {
          int left = i + 1, right = n - 1;

          while (left < right) {
            int diff = s - a[i] - a[left] - a[right];

            if (diff == 0) {
              found = true;
              minDiff = 0;
              break;
            }

            if (Math.abs(diff) < Math.abs(minDiff) ||
                (Math.abs(diff) == Math.abs(minDiff) && (diff > minDiff))) {
              minDiff = diff;
            }

            if (diff > 0) {
              left++;
            } else {
              right--;
            }
          }

          if (found) {
            break;
          }
        }

        System.out.println((s - minDiff));
      }
    }
  }
}