import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        var pos = pairWithTargetSum(a, s);
        System.out.printf("%d %d\n", pos[0], pos[1]);
      }
    }
  }

  // O(n) / O(n)
  public static int[] pairWithTargetSum(int[] a, int s) {
    int[] pos = new int[] {-1, -1};
    Map<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < a.length - 1; i++) {
      int idx = m.getOrDefault(s - a[i], -1);

      if (idx != -1) {
        pos[0] = i;
        pos[1] = idx;
        break;
      }

      m.put(a[i], i);
    }

    return pos;
  }
}