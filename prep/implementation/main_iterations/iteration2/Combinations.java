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

      List<List<Integer>> combinations = combinations(a, n, k);
      for (List<Integer> comb : combinations) {
        for (int c : comb) {
          System.out.printf("%d ", c);
        }
        System.out.println();
      }
    }
  }

  public static List<List<Integer>> combinations(int[] a, int n, int k) {
    List<List<Integer>> combs = new ArrayList<>();
    combinations(a, 0, n, k, new ArrayList<>(), combs);

    return combs;
  }

  private static void combinations(int[] a, int currIdx, int n, int k,
                                   List<Integer> currComb,
                                   List<List<Integer>> combs) {
    if (currComb.size() == k) {
      List<Integer> tmp = new ArrayList<>();
      for (int c : currComb) {
        tmp.add(c);
      }
      combs.add(tmp);

      return;
    }

    if (currIdx == n) {
      return;
    }

    currComb.add(a[currIdx]);
    combinations(a, currIdx + 1, n, k, currComb, combs);
    currComb.remove(currComb.size() - 1);
    combinations(a, currIdx + 1, n, k, currComb, combs);
  }
}