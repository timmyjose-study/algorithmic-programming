import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TargetSumDP {
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

        System.out.println(countWays(a, s));
      }
    }
  }

  public static int countWays(int[] a, int sum) {}
}