import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NextSmallerElement {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = nextSmallerElement(a);
        for (int r : res) {
          System.out.printf("%d ", r);
        }
        System.out.println();
      }
    }
  }

  // O(n) / O(n)
  public static int[] nextSmallerElement(int[] a) {
    int n = a.length;

    int[] res = new int[n];
    Arrays.fill(res, -1);

    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!q.isEmpty() && (a[i] < a[q.peekLast()])) {
        res[q.pollLast()] = a[i];
      }
      q.addLast(i);
    }

    return res;
  }
}