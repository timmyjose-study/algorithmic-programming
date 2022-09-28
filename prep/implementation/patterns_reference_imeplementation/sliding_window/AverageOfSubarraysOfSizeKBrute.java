import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n * k)
public class AverageOfSubarraysOfSizeKBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      double[] res = new double[n - k + 1];
      double sum = 0.0;

      for (int i = 0; i < n - k + 1; i++) {
        sum = 0.0;
        for (int j = i; j < i + k; j++) {
          sum += a[j];
        }
        res[i] = sum / k;
      }

      for (double r : res) {
        System.out.printf("%.2f ", r);
      }
      System.out.println();
    }
  }
}