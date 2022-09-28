import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n)
public class AverageOfSubarraysOfSizeK {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      double[] res = new double[n - k + 1];
      double windowSum = 0.0;
      int windowStart = 0;
      for (int windowEnd = 0; windowEnd < n; windowEnd++) {
        windowSum += a[windowEnd];
        if (windowEnd >= k - 1) {
          res[windowStart] = windowSum / k;
          windowSum -= a[windowStart];
          windowStart++;
        }
      }

      for (double r : res) {
        System.out.printf("%.2f ", r);
      }
      System.out.println();
    }
  }
}