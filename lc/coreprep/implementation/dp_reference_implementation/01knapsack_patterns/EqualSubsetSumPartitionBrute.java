import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class EqualSubsetSumPartitionBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(canPartition(a));
      }
    }
  }

  // O(2n) / O(n)
  public static boolean canPartition(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }

    if (sum % 2 != 0 || a.length == 0) {
      return false;
    }

    return canPartition(a, sum / 2, 0);
  }

  private static boolean canPartition(int[] a, int sum, int currIdx) {
    if (sum == 0) {
      return true;
    }

    if (currIdx >= a.length) {
      return false;
    }

    boolean can1 = false;

    if (a[currIdx] <= sum) {
      can1 = canPartition(a, sum - a[currIdx], currIdx + 1);
    }

    return can1 || canPartition(a, sum, currIdx + 1);
  }
}