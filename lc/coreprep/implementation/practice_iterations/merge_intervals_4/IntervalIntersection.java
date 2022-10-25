import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n + m) / O(1)
public class IntervalIntersection {
  static class Interval {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        List<Interval> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
          int start = in.nextInt();
          int end = in.nextInt();
          a.add(new Interval(start, end));
        }

        int m = in.nextInt();
        List<Interval> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
          int start = in.nextInt();
          int end = in.nextInt();
          b.add(new Interval(start, end));
        }

        List<Interval> res = new ArrayList<>();

        int left = 0, right = 0;
        while (left < n && right < m) {
          if ((a.get(left).start >= b.get(right).start &&
               a.get(left).start <= b.get(right).end) ||
              (b.get(right).start >= a.get(left).start &&
               b.get(right).end <= a.get(left).end)) {
            res.add(
                new Interval(Math.max(a.get(left).start, b.get(right).start),
                             Math.min(a.get(left).end, b.get(right).end)));
          }

          if (a.get(left).end < b.get(right).end) {
            left++;
          } else {
            right++;
          }
        }

        for (Interval inter : res) {
          System.out.printf("%d %d\n", inter.start, inter.end);
        }
      }
    }
  }
}