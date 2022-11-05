import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AverageOfSubarraysOfSizeKBrute {
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

        var res = averagesOfSubarraysOfSizeK(a, k);
        for (var r : res) {
          System.out.printf("%.1f ", r);
        }
        System.out.println();
      }
    }
  }

  // O(nk) / O(1)
  public static double[] averagesOfSubarraysOfSizeK(int[] a, int k) {
    int n = a.length;
    double[] res = new double[n - k + 1];
    double sum = 0.0;

    for (int i = 0; i < n - k + 1; i++) {
      sum = 0.0;
      for (int j = i; j < i + k; j++) {
        sum += a[j];
      }

      res[i] = sum / (double)k;
    }

    return res;
  }
}