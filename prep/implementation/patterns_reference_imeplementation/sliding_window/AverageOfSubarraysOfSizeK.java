import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class AverageOfSubarraysOfSizeK {
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

        double[] res = new double[n - k + 1];
        int sum = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          sum += a[windowEnd];

          if (windowEnd >= k - 1) {
            res[windowStart] = (double)sum / k;
            sum -= a[windowStart];
            windowStart++;
          }
        }

        for (double r : res) {
          System.out.printf("%.1f ", r);
        }
        System.out.println();
      }
    }
  }
}