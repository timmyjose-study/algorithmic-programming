import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KClosestPointsToOrigin {
  static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

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
        for (var r : res) {
          System.out.printf("%d %d\n", r.x, r.y);
        }
      }
    }
  }

  private static double euclideanDistance(Point p) {
    return Math.sqrt(p.x * p.x + p.y * p.y);
  }

  // O(nlogk) / O(k)
  public static List<Point> kClosestPointsToOrigin(Point[] a, int k) {
    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>((x, y)
                                -> Double.compare(euclideanDistance(a[y]),
                                                  euclideanDistance(a[x])));

    for (int i = 0; i < k; i++) {
      maxHeap.add(i);
    }

    for (int i = k; i < a.length; i++) {
      if (euclideanDistance(a[i]) < euclideanDistance(a[maxHeap.peek()])) {
        maxHeap.poll();
        maxHeap.add(i);
      }
    }

    List<Point> res = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
      res.add(a[maxHeap.poll()]);
    }

    return res;
  }
}