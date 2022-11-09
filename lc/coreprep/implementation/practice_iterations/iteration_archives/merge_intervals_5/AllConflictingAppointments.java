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

  static class Pair {
    Interval first;
    Interval second;

    Pair(Interval first, Interval second) {
      this.first = first;
      this.second = second;
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

        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
            if (hasConflict(a.get(i), a.get(j))) {
              res.add(new Pair(a.get(i), a.get(j)));
            }
          }
        }

        System.out.println(res.size());
        for (Pair p : res) {
          System.out.printf("%d %d %d %d\n", p.first.start, p.first.end,
                            p.second.start, p.second.end);
        }
      }
    }
  }
}