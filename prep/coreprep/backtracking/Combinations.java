import java.util.*;

public class Combinations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();

      if (k > n) {
        throw new IllegalArgumentException("invalid k value");
      }

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> res = combinations(a, n, k);
      for (List<Integer> currRes : res) {
        for (int e : currRes) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }

  private static List<List<Integer>> combinations(int[] a, int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(a, 0, n, k, new ArrayList<>(), res);
    return res;
  }

  private static void backtrack(int[] a, int currIdx, int len, int k,
                                List<Integer> currRes,
                                List<List<Integer>> res) {
    if (currRes.size() == k) {
      List<Integer> tmp = new ArrayList<>();
      for (int e : currRes) {
        tmp.add(e);
      }
      res.add(tmp);
      return;
    }

    if (currIdx == len) {
      return;
    }

    currRes.add(a[currIdx]);
    backtrack(a, currIdx + 1, len, k, currRes, res);
    currRes.remove(currRes.size() - 1);
    backtrack(a, currIdx + 1, len, k, currRes, res);
  }
}