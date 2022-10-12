import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n2) / O(1)
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

        double[] res = new double[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
          double sum = 0.0;

          for (int j = i; j < i + k; j++) {
            sum += a[j];
          }
          res[i] = sum / k;
        }

        for (double d : res) {
          System.out.printf("%.1f ", d);
        }
        System.out.println();
      }
    }
  }
}