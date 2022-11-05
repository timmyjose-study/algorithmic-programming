import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ConflictingAppointments {
  record Interval(int start, int end) {}

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

        System.out.println(hasNoConflict(a));
      }
    }
  }

  // O(nlogn) / O(1)
  public static boolean hasNoConflict(List<Interval> a) {
    a.sort((x, y) -> Integer.compare(x.start, y.start));

    BiPredicate<Interval, Interval> hasConflict = (x, y) -> {
      return (x.start >= y.start && x.start < y.end) ||
          (y.start >= x.start && y.start < x.end);
    };

    for (int i = 0; i < a.size() - 1; i++) {
      if (hasConflict.test(a.get(i), a.get(i + 1))) {
        return false;
      }
    }
    return true;
  }
}