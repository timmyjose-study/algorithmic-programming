import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TargetSumBrute {
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

        System.out.println(countWays(a, s));
      }
    }
  }

  public static int countWays(int[] a, int sum) {
    return countWays(a, sum, 0, 0);
  }

  // o(2n) / O(n)
  private static int countWays(int[] a, int sum, int currSum, int currIdx) {
    if (currIdx == a.length && (sum == currSum)) {
      return 1;
    }

    if (currIdx >= a.length) {
      return 0;
    }

    int plusWays = countWays(a, sum, currSum + a[currIdx], currIdx + 1);
    int minusWays = countWays(a, sum, currSum - a[currIdx], currIdx + 1);

    return plusWays + minusWays;
  }
}