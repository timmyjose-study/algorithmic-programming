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
        List<Interval> a = new ArrayList<>();
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

        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();

        while (i < n && j < m) {
          if ((a.get(i).start >= b.get(j).start &&
               a.get(i).start <= b.get(j).end) ||
              (b.get(j).start >= a.get(i).start &&
               b.get(j).start <= a.get(i).end)) {
            res.add(new Interval(Math.max(a.get(i).start, b.get(j).start),
                                 Math.min(a.get(i).end, b.get(j).end)));
          }

          if (a.get(i).end <= b.get(j).end) {
            i++;
          } else {
            j++;
          }
        }

        for (Interval inter : res) {
          System.out.printf("%d %d\n", inter.start, inter.end);
        }
      }
    }
  }
}