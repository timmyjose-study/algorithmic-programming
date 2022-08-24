import java.util.*;

public class Subsets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> res = subsets(a, n);
      for (List<Integer> currRes : res) {
        for (int e : currRes) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }

      res = subsetsBitMask(a, n);
      for (List<Integer> currRes : res) {
        for (int e : currRes) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }

  // O(n * 2^n) / O(n)
  private static List<List<Integer>> subsetsBitMask(int[] a, int n) {
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < 1 << n; i++) {
      List<Integer> currRes = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          currRes.add(a[j]);
        }
      }
      res.add(currRes);
    }

    return res;
  }

  // O(n * 2^n)
  private static List<List<Integer>> subsets(int[] a, int n) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(a, 0, n, new ArrayList<>(), res);
    return res;
  }

  private static void backtrack(int[] a, int currIdx, int len,
                                List<Integer> currRes,
                                List<List<Integer>> res) {
    if (currIdx == len) {
      List<Integer> tmp = new ArrayList<>();
      for (int e : currRes) {
        tmp.add(e);
      }
      res.add(tmp);
      return;
    } else {
      currRes.add(a[currIdx]);
      backtrack(a, currIdx + 1, len, currRes, res);
      currRes.remove(currRes.size() - 1);
      backtrack(a, currIdx + 1, len, currRes, res);
    }
  }
}