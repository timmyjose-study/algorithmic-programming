import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KadanesAlgorithm {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.printf("%d\n", kadane(a));
      }
    }
  }

  private static int kadane(int[] a) {
    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = 0;

    for (int e : a) {
      maxEndingHere += e;
      maxSoFar = Math.max(maxSoFar, maxEndingHere);

      if (maxEndingHere < 0) {
        maxEndingHere = 0;
      }
    }

    return maxSoFar;
  }
}