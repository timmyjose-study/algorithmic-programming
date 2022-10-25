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

  // O(n * nCk) / O(n)
  private static List<List<Integer>> combine(int[] a, int n, int k) {
    List<List<Integer>> combinations = new ArrayList<>();
    combine(a, n, k, 0, new ArrayList<>(), combinations);
    return combinations;
  }

  private static void combine(int[] a, int n, int k, int currIdx,
                              List<Integer> comb,
                              List<List<Integer>> combinations) {
    if (comb.size() == k) {
      List<Integer> tmp = new ArrayList<>();
      for (int c : comb) {
        tmp.add(c);
      }

      combinations.add(tmp);
      return;
    }

    if (currIdx == n) {
      return;
    }

    comb.add(a[currIdx]);
    combine(a, n, k, currIdx + 1, comb, combinations);
    comb.remove(comb.size() - 1);
    combine(a, n, k, currIdx + 1, comb, combinations);
  }
}