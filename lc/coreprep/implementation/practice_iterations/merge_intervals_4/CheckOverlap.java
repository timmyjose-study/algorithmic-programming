import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(nlogn) / O(1)
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

        a.sort((x, y) -> Integer.compare(x.start, y.start));

        boolean isOverlapping = false;
        for (int i = 1; i < n; i++) {
          if (a.get(i).start <= a.get(i - 1).end) {
            isOverlapping = true;
            break;
          }
        }

        System.out.println(isOverlapping);
      }
    }
  }
}