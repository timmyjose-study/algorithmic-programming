import java.util.*;

public class Permutations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> permutations = permute(a, n);
      for (List<Integer> perm : permutations) {
        for (int p : perm) {
          System.out.printf("%d ", p);
        }
        System.out.println();
      }
    }
  }
}