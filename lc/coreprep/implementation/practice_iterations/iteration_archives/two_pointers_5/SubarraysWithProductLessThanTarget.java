import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n2) / O(n2)
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
        int product = 1, windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          product *= a[windowEnd];

          while (product >= s) {
            product /= a[windowStart];
            windowStart++;
          }

          List<Integer> lst = new LinkedList<>();
          for (int j = windowEnd; j >= windowStart; j--) {
            lst.add(0, a[j]);
            res.add(new ArrayList<>(lst));
          }
        }

        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }
}