import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        System.out.println(tripletSumCloseToTarget(a, s));
      }
    }
  }

  // O(n2) / O(1)
  public static int tripletSumCloseToTarget(int[] a, int s) {
    Arrays.sort(a);

    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < a.length - 1; i++) {
      int left = i + 1, right = a.length - 1;

      while (left < right) {
        int diff = s - a[i] - a[left] - a[right];

        if (diff == 0) {
          return s;
        }

        if (Math.abs(diff) < Math.abs(minDiff) ||
            (Math.abs(diff) == Math.abs(minDiff) && diff > minDiff)) {
          minDiff = diff;
        }

        if (diff > 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return s - minDiff;
  }
}