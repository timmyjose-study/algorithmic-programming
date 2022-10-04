import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
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

        int lpos = -1, rpos = -1;
        int left = 0, right = n - 1;

        while (left < right) {
          int sum = a[left] + a[right];

          if (sum == s) {
            lpos = left;
            rpos = right;
            break;
          } else if (sum < s) {
            left++;
          } else {
            right--;
          }
        }

        System.out.printf("%d %d\n", lpos, rpos);
      }
    }
  }
}