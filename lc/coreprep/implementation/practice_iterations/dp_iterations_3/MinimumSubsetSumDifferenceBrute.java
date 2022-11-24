import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumSubsetSumDifferenceBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(minDiff(a));
      }
    }
  }

  // O(2n) / O(n)
  public static int minDiff(int[] a) { return minDiff(a, 0, 0, 0); }

  private static int minDiff(int[] a, int sum1, int sum2, int currIdx) {
    if (currIdx == a.length) {
      return Math.abs(sum1 - sum2);
    }

    return Math.min(minDiff(a, sum1 + a[currIdx], sum2, currIdx + 1),
                    minDiff(a, sum1, sum2 + a[currIdx], currIdx + 1));
  }
}