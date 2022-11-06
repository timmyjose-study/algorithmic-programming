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
  public static int[] previousSmallerElement(int[] a) {
    int n = a.length;

    int[] res = new int[n];
    Arrays.fill(res, -1);

    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!q.isEmpty() && (a[i] <= a[q.peekLast()])) {
        q.pollLast();
      }

      if (!q.isEmpty()) {
        res[i] = a[q.peekLast()];
      }
      q.addLast(i);
    }

    return res;
  }
}