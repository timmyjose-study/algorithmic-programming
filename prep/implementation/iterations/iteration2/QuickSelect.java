import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      while (nq-- > 0) {
        int k = in.nextInt();
        System.out.println(select(a, 0, n - 1, k));
      }
    }
  }
}