import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MaximumSumSubarrayOfSizeKBrute {
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

        System.out.println(maximumSumSubarrayOfSizeK(a, k));
      }
    }
  }

  // O(nk) / O(1)
  public static int maximumSumSubarrayOfSizeK(int[] a, int k) {
    int n = a.length;
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < n - k + 1; i++) {
      sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += a[j];
      }
      maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
  }
}