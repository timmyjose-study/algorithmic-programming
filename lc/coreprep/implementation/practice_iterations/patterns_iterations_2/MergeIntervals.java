import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        List<Interval> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
          int start = in.nextInt();
          int end = in.nextInt();
          a.add(new Interval(start, end));
        }

        List<Interval> res = mergeIntervals(a);
        for (var r : res) {
          System.out.printf("%d %d\n", r.start, r.end);
        }
      }
    }
  }

  // O(nlogn) / O(1)
  public static List<Interval> mergeIntervals(List<Interval> a) {
    a.sort((x, y) -> Integer.compare(x.start, y.start));

    List<Interval> res = new ArrayList<>();
    int start = a.get(0).start;
    int end = a.get(0).end;

    for (int i = 1; i < a.size(); i++) {
      if (a.get(i).start <= end) {
        end = Math.max(end, a.get(i).end);
      } else {
        res.add(new Interval(start, end));
        start = a.get(i).start;
        end = a.get(i).end;
      }
    }

    res.add(new Interval(start, end));

    return res;
  }
}