import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n! * n) / O(n! * n)
public class PermutationWithRepetitions {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
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
  }

  private static List<List<Integer>> permute(int[] a) {
    Arrays.sort(a);

    List<List<Integer>> perms = new ArrayList<>();

    boolean[] visited = new boolean[a.length];
    Arrays.fill(visited, false);

    List<Integer> currPerm = new ArrayList<>();
    permute(a, 0, visited, currPerm, perms);

    return perms;
  }

  private static void permute(int[] a, int currIdx, boolean[] visited,
                              List<Integer> currPerm,
                              List<List<Integer>> perms) {
    if (currPerm.size() == a.length) {
      perms.add(new ArrayList<>(currPerm));
      return;
    }

    if (currIdx == a.length) {
      return;
    }

    for (int i = 0; i < a.length; i++) {
      if (visited[i]) {
        continue;
      }

      if (i > 0 && (a[i] == a[i - 1] && visited[i - 1])) {
        continue;
      }

      visited[i] = true;
      currPerm.add(a[i]);
      permute(a, currIdx + 1, visited, currPerm, perms);
      visited[i] = false;
      currPerm.remove(currPerm.size() - 1);
      permute(a, currIdx + 1, visited, currPerm, perms);
    }
  }
}