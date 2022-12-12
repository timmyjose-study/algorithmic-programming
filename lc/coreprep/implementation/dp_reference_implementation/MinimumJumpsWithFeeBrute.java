import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumJumpsWithFeeBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] fees = new int[n];
        for (int i = 0; i < n; i++) {
          fees[i] = in.nextInt();
        }

        System.out.println(minFee(fees));
      }
    }
  }

  // O(3n) / O(n)
  public static int minFee(int[] fees) { return minFee(fees, 0); }

  private static int minFee(int[] fees, int currIdx) {
    if (currIdx > fees.length - 1) {
      return 0;
    }

    return fees[currIdx] +
        Math.min(Math.min(minFee(fees, currIdx + 1), minFee(fees, currIdx + 2)),
                 minFee(fees, currIdx + 3));
  }
}