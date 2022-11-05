import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        var res = subarraysWithProductLessThanTarget(a, s);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(n2) / O(n2)
  public static List<List<Integer>> subarraysWithProductLessThanTarget(int[] a,
                                                                       int s) {
    List<List<Integer>> res = new ArrayList<>();
    int product = 1;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
      product *= a[windowEnd];

      while (product >= s) {
        product /= a[windowStart];
        windowStart++;
      }

      List<Integer> sub = new LinkedList<>();
      for (int i = windowEnd; i >= windowStart; i--) {
        sub.add(0, a[i]);
        res.add(new ArrayList<>(sub));
      }
    }

    return res;
  }
}