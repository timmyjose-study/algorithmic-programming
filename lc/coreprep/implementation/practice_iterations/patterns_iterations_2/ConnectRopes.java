import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ConnectRopes {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(connectRopes(a));
      }
    }
  }

  // O(nlogn) / O(n)
  public static int connectRopes(int[] a) {
    PriorityQueue<Integer> minHeap =
        new PriorityQueue<>((x, y) -> Integer.compare(x, y));

    for (int e : a) {
      minHeap.add(e);
    }

    int cost = 0;
    while (minHeap.size() > 1) {
      int f = minHeap.poll();
      int s = minHeap.poll();

      cost += f + s;
      minHeap.add(f + s);
    }

    return cost;
  }
}