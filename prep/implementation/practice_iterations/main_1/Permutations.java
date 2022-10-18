import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Permutations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      var perms = permute(a);
      for (var perm : perms) {
        for (int p : perm) {
          System.out.printf("%d ", p);
        }
        System.out.println();
      }
    }
  }

  // O(n x n!) / O(n x n!)
  private static List<List<Integer>> permute(int[] a) {
    List<List<Integer>> perms = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    permute(a, 0, visited, new ArrayList<>(), perms);

    return perms;
  }

  private static void permute(int[] a, int currIdx, Set<Integer> visited,
                              List<Integer> currPerm,
                              List<List<Integer>> allPerms) {
    if (currPerm.size() == a.length) {
      allPerms.add(new ArrayList<>(currPerm));
    }

    if (currIdx == a.length) {
      return;
    }

    for (int e : a) {
      if (!visited.contains(e)) {
        visited.add(e);
        currPerm.add(e);
        permute(a, currIdx + 1, visited, currPerm, allPerms);
        visited.remove(e);
        currPerm.remove(currPerm.size() - 1);
        permute(a, currIdx + 1, visited, currPerm, allPerms);
      }
    }
  }
}