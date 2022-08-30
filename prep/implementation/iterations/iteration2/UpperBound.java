import java.util.*;

public class UpperBound {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a, n);
      Arrays.sort(a);
      display(a, n);

      while (nq-- > 0) {
        int elem = in.nextInt();
        System.out.printf("%d\n%d\n", upperBound(a, 0, n - 1, elem),
                          upperBoundRec(a, 0, n - 1, elem));
      }
    }
  }
}