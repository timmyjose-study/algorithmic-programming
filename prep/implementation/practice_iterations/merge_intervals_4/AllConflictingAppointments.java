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

        List<List<Interval>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
            if (hasConflict(a.get(i), a.get(j))) {
              res.add(Arrays.asList(a.get(i), a.get(j)));
            }
          }
        }

        System.out.println(res.size());
        for (var r : res) {
          System.out.printf("%d %d %d %d\n", r.get(0).start, r.get(0).end,
                            r.get(1).start, r.get(1).end);
        }
      }
    }
  }

  private static boolean hasConflict(Interval a, Interval b) {
    return (a.start >= b.start && a.start < b.end) ||
        (b.start >= a.start && b.start < a.end);
  }
}