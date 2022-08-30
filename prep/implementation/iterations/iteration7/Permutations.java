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

  // O(n * n!) / O(n)
  private static List<List<Integer>> permute(int[] a, int n) {
    List<List<Integer>> permutations = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    permute(a, n, visited, new ArrayList<>(), permutations);
    return permutations;
  }

  private static void permute(int[] a, int n, Set<Integer> visited,
                              List<Integer> perm,
                              List<List<Integer>> permutations) {
    if (perm.size() == n) {
      List<Integer> tmp = new ArrayList<>();
      for (int p : perm) {
        tmp.add(p);
      }
      permutations.add(tmp);
    } else {
      for (int e : a) {
        if (!visited.contains(e)) {
          perm.add(e);
          visited.add(e);
          permute(a, n, visited, perm, permutations);
          visited.remove(e);
          perm.remove(perm.size() - 1);
        }
      }
    }
  }
}