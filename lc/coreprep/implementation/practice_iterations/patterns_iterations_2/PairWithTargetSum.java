import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class PairWithTargetSum {
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

        var pos = pairWithTargetSum(a, s);
        System.out.printf("%d %d\n", pos[0], pos[1]);
      }
    }
  }

  // O(n) / O(1)
  public static int[] pairWithTargetSum(int[] a, int s) {
    int left = 0, right = a.length - 1;

    while (left < right) {
      int sum = a[left] + a[right];

      if (sum == s) {
        return new int[] {left, right};
      } else if (sum < s) {
        left++;
      } else {
        right--;
      }
    }

    return new int[] {-1, -1};
  }
}