import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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
          int start = in.nextInt();
          int end = in.nextInt();
          a.add(new Interval(start, end));
        }

        int start = in.nextInt();
        int end = in.nextInt();
        Interval newInterval = new Interval(start, end);

        List<Interval> res = insertInterval(a, newInterval);
        for (var r : res) {
          System.out.printf("%d %d\n", r.start, r.end);
        }
      }
    }
  }

  // O(n) / O(1)
  public static List<Interval> insertInterval(List<Interval> a,
                                              Interval newInterval) {
    List<Interval> res = new ArrayList<>();

    int i = 0;
    while (i < a.size() && a.get(i).end < newInterval.start) {
      res.add(a.get(i));
      i++;
    }

    while (i < a.size() && a.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, a.get(i).start);
      newInterval.end = Math.max(newInterval.end, a.get(i).end);
      i++;
    }

    res.add(newInterval);

    while (i < a.size()) {
      res.add(a.get(i));
      i++;
    }

    return res;
  }
}