import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AllConflictingAppointments {
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

        var res = findAllConflictingAppointments(a);
        System.out.println(res.size());
        for (var r : res) {
          System.out.printf("%d %d %d %d\n", r[0].start, r[0].end, r[1].start,
                            r[1].end);
        }
      }
    }
  }

  // O(n2) / O(1)
  public static List<Interval[]>
  findAllConflictingAppointments(List<Interval> a) {
    List<Interval[]> res = new ArrayList<>();

    BiPredicate<Interval, Interval> hasConflict = (x, y) -> {
      return (x.start >= y.start && x.start < y.end) ||
          (y.start >= x.start && y.start < x.end);
    };

    for (int i = 0; i < a.size() - 1; i++) {
      for (int j = i + 1; j < a.size(); j++) {
        if (hasConflict.test(a.get(i), a.get(j))) {
          res.add(new Interval[] {a.get(i), a.get(j)});
        }
      }
    }

    return res;
  }
}