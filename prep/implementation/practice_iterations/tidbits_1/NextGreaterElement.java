import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(n)
public class NextGreaterElement {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
          while (!st.isEmpty() && (a[st.peek()] < a[i])) {
            res[st.pop()] = a[i];
          }
          st.push(i);
        }

        for (int e : res) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }
}