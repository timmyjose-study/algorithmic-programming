import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class InsertInterval {
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
          int s = in.nextInt();
          int e = in.nextInt();

          a.add(new Interval(s, e));
        }

        int s = in.nextInt();
        int e = in.nextInt();
        Interval newInterval = new Interval(s, e);

        List<Interval> res = new ArrayList<>();

        int i = 0;
        while (i < n && a.get(i).end < newInterval.start) {
          res.add(a.get(i));
          i++;
        }

        while (i < n && a.get(i).start <= newInterval.end) {
          newInterval.start = Math.min(newInterval.start, a.get(i).start);
          newInterval.end = Math.max(newInterval.end, a.get(i).end);
          i++;
        }

        res.add(newInterval);

        while (i < n) {
          res.add(a.get(i));
          i++;
        }

        for (var inter : res) {
          System.out.printf("%d %d\n", inter.start, inter.end);
        }
      }
    }
  }
}