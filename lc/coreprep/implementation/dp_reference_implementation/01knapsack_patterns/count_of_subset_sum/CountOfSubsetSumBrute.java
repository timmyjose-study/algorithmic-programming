import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CountOfSubsetSumBrute {
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

        System.out.println(countSubsets(a, s));
      }
    }
  }

  // O(2n) / O(n)
  public static int countSubsets(int[] a, int sum) {
    return countSubsets(a, sum, 0);
  }

  private static int countSubsets(int[] a, int sum, int currIdx) {
    if (sum == 0) {
      return 1;
    }

    if (currIdx >= a.length) {
      return 0;
    }

    int withCount = 0;

    if (a[currIdx] <= sum) {
      withCount = countSubsets(a, sum - a[currIdx], currIdx + 1);
    }

    int withoutCount = countSubsets(a, sum, currIdx + 1);

    return withCount + withoutCount;
  }
}