import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n2) / O(1)
public class AllConflictingAppointments {
  static class Interval {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  static class Pair {
    Interval first;
    Interval second;

    Pair(Interval first, Interval second) {
      this.first = first;
      this.second = second;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        List<Interval> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
          int s = in.nextInt();
          int e = in.nextInt();
          a.add(new Interval(s, e));
        }

        BiFunction<Interval, Interval, Boolean> isOverlapping =
            (Interval x, Interval y) -> {
          return (x.start >= y.start && x.start < y.end) ||
              (y.start >= x.start && y.start < x.end);
        };

        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
            if (isOverlapping.apply(a.get(i), a.get(j))) {
              res.add(new Pair(a.get(i), a.get(j)));
            }
          }
        }

        System.out.println(res.size());
        for (var p : res) {
          System.out.printf("%d %d %d %d\n", p.first.start, p.first.end,
                            p.second.start, p.second.end);
        }
      }
    }
  }
}