import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class PreviousSmallerElement {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = previousSmallerElement(a);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(n) / O(n)
  public static List<Integer> previousSmallerElement(int[] a) {
    Map<Integer, Integer> mapping = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      mapping.put(i, -1);
    }

    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < a.length; i++) {
      while (!q.isEmpty() && a[i] < a[q.peekLast()]) {
        q.pollLast();
      }

      if (!q.isEmpty()) {
        mapping.put(i, q.peekLast());
      }
      q.addLast(i);
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      int idx = mapping.get(i);

      if (idx == -1) {
        res.add(-1);
      } else {
        res.add(a[idx]);
      }
    }

    return res;
  }
}