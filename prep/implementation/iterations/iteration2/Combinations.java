import java.util.*;

public class Combinations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();

      if (k < 0 || k > n) {
        throw new IllegalArgumentException("invalid value of k");
      }

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> combinations = combine(a, n, k);
      for (List<Integer> comb : combinations) {
        for (int c : comb) {
          System.out.printf("%d ", c);
        }
        System.out.println();
      }
    }
  }
}