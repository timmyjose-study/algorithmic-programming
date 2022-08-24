import java.util.*;

public class Permutations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> res = permutations(a);
      for (List<Integer> currRes : res) {
        for (int e : currRes) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }

  // O(n * n!) / O(n)
  private static List<List<Integer>> permutations(int[] a) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    backtrack(a, visited, new ArrayList<>(), res);

    return res;
  }

  private static void backtrack(int[] a, Set<Integer> visited,
                                List<Integer> currRes,
                                List<List<Integer>> res) {
    if (currRes.size() == a.length) {
      List<Integer> tmp = new ArrayList<>();
      for (int e : currRes) {
        tmp.add(e);
      }
      res.add(tmp);
    } else {
      for (int e : a) {
        if (!visited.contains(e)) {
          visited.add(e);
          currRes.add(e);
          backtrack(a, visited, currRes, res);
          visited.remove(e);
          currRes.remove(currRes.size() - 1);
        }
      }
    }
  }
}