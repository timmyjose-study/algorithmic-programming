import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class PairWithTargetSum {
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

        int[] res = new int[] {-1, -1};

        int i = 0, j = n - 1;
        while (i <= j) {
          int sum = a[i] + a[j];
          if (sum < k) {
            i++;
          } else if (sum > k) {
            j--;
          } else {
            res = new int[] {i, j};
            break;
          }
        }

        System.out.printf("%d %d\n", res[0], res[1]);
      }
    }
  }
}