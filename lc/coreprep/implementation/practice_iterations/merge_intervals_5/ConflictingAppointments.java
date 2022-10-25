import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(1)
public class ConflictingAppointments {
  static class Interval {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  private static boolean hasConflict(Interval a, Interval b) {
    return (a.start >= b.start && a.start < b.end) ||
        (b.start >= a.start && b.start < a.end);
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

        a.sort((x, y) -> Integer.compare(x.start, y.start));

        boolean canAttendAll = true;
        for (int i = 1; i < n; i++) {
          if (hasConflict(a.get(i), a.get(i - 1))) {
            canAttendAll = false;
            break;
          }
        }

        System.out.println(canAttendAll);
      }
    }
  }
}