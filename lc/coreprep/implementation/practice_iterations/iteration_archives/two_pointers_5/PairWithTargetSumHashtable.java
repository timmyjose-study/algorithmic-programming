import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
public class PairWithTargetSumHashtable {
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

        Map<Integer, Integer> pos = new HashMap<>();
        int lpos = -1, rpos = -1;

        for (int i = 0; i < n; i++) {
          if (pos.containsKey(s - a[i])) {
            lpos = i;
            rpos = pos.get(s - a[i]);
            break;
          }

          pos.put(a[i], i);
        }

        System.out.printf("%d %d\n", lpos, rpos);
      }
    }
  }
}