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

        a.sort((x, y) -> Integer.compare(x.start, y.start));

        boolean valid = true;
        for (int i = 1; i < n; i++) {
          if (a.get(i).start <= a.get(i - 1).end) {
            valid = false;
            break;
          }
        }

        System.out.println(valid);
      }
    }
  }
}