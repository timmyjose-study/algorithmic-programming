import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n3) / O(1)
public class SubarraysWithProductLessThanTarget {
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

        List<List<Integer>> res = new ArrayList<>();
        int windowStart = 0;
        int product = 1;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          product *= a[windowEnd];

          while (product >= s) {
            product /= a[windowStart];
            windowStart++;
          }

          List<Integer> lst = new LinkedList<>();
          for (int i = windowEnd; i >= windowStart; i--) {
            lst.add(0, a[i]);
            res.add(new ArrayList<>(lst));
          }
        }

        for (var sub : res) {
          for (int e : sub) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }
}