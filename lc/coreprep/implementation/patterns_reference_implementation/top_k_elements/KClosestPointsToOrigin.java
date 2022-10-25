import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KClosestPointsToOrigin {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        Point[] a = new Point[n];
        for (int i = 0; i < n; i++) {
          int x = in.nextInt();
          int y = in.nextInt();
          a[i] = new Point(x, y);
        }

        var res = kClosestPointsToOrigin(a, k);
        for (Point p : res) {
          System.out.printf("%d %d\n", p.x(), p.y());
        }
      }
    }
  }

  record Point(int x, int y) {
    double distanceFromOrigin() {
      return Math.sqrt(this.x * this.x + this.y * this.y);
    }
  }

  // O(nlogk) / O(k)
  public static List<Point> kClosestPointsToOrigin(Point[] a, int k) {
    PriorityQueue<Point> maxHeap =
        new PriorityQueue<>((p1, p2)
                                -> Double.compare(p2.distanceFromOrigin(),
                                                  p1.distanceFromOrigin()));

    for (int i = 0; i < k; i++) {
      maxHeap.add(a[i]);
    }

    for (int i = k; i < a.length; i++) {
      if (a[i].distanceFromOrigin() < maxHeap.peek().distanceFromOrigin()) {
        maxHeap.poll();
        maxHeap.add(a[i]);
      }
    }

    return new ArrayList<>(maxHeap);
  }
}