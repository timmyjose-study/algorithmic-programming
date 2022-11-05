import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CheckOverlap {
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

        System.out.println(checkOverlap(a));
      }
    }
  }

  // O(nlogn) / O(1)
  public static boolean checkOverlap(List<Interval> a) {
    a.sort((x, y) -> Integer.compare(x.start, y.start));

    BiFunction<Interval, Interval, Boolean> hasOverlap = (x, y) -> {
      return (x.start >= y.start && x.start <= y.end) ||
          (y.start >= x.start && y.start <= x.end);
    };

    for (int i = 0; i < a.size() - 1; i++) {
      if (hasOverlap.apply(a.get(i), a.get(i + 1))) {
        return true;
      }
    }

    return false;
  }
}