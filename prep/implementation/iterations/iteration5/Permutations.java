import java.util.*;

public class Permutations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> permutations = permutations(a, n);
      for (List<Integer> perm : permutations) {
        for (int p : perm) {
          System.out.printf("%d ", p);
        }
        System.out.println();
      }
    }
  }

  public static List<List<Integer>> permutations(int[] a, int n) {
    List<List<Integer>> perms = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    permutations(a, n, visited, new ArrayList<>(), perms);

    return perms;
  }

  private static void permutations(int[] a, int n, Set<Integer> visited,
                                   List<Integer> currPerm,
                                   List<List<Integer>> perms) {
    if (currPerm.size() == n) {
      List<Integer> tmp = new ArrayList<>();
      for (int p : currPerm) {
        tmp.add(p);
      }
      perms.add(tmp);
      return;
    }
    for (int e : a) {
      if (!visited.contains(e)) {
        visited.add(e);
        currPerm.add(e);
        permutations(a, n, visited, currPerm, perms);
        visited.remove(e);
        currPerm.remove(currPerm.size() - 1);
      }
    }
  }
}