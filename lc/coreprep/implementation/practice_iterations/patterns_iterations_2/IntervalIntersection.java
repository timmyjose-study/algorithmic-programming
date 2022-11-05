import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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
        List<Interval> b = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
          int start = in.nextInt();
          int end = in.nextInt();
          b.add(new Interval(start, end));
        }

        List<Interval> res = intersection(a, b);
        for (var r : res) {
          System.out.printf("%d %d\n", r.start, r.end);
        }
      }
    }
  }

  // O(n + m) / O(1)
  public static List<Interval> intersection(List<Interval> a,
                                            List<Interval> b) {
    List<Interval> res = new ArrayList<>();
    int i = 0, j = 0;

    BiPredicate<Interval, Interval> hasOverlap = (x, y) -> {
      return (x.start >= y.start && x.start <= y.end) ||
          (y.start >= x.start && y.start <= x.end);
    };

    while (i < a.size() && j < b.size()) {
      if (hasOverlap.test(a.get(i), b.get(j))) {
        int start = Math.max(a.get(i).start, b.get(j).start);
        int end = Math.min(a.get(i).end, b.get(j).end);

        res.add(new Interval(start, end));
      }

      if (a.get(i).end < b.get(j).end) {
        i++;
      } else {
        j++;
      }
    }

    return res;
  }
}