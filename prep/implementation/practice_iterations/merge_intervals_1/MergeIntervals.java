import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(n)
public class MergeIntervals {
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
          int s = in.nextInt();
          int e = in.nextInt();

          a.add(new Interval(s, e));
        }

        a.sort((x, y) -> Integer.compare(x.start, y.start));

        int start = a.get(0).start;
        int end = a.get(0).end;
        List<Interval> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {
          if (a.get(i).start <= end) {
            end = Math.max(end, a.get(i).end);
          } else {
            res.add(new Interval(start, end));
            start = a.get(i).start;
            end = a.get(i).end;
          }
        }

        res.add(new Interval(start, end));

        for (var inter : res) {
          System.out.printf("%d %d\n", inter.start, inter.end);
        }
      }
    }
  }
}