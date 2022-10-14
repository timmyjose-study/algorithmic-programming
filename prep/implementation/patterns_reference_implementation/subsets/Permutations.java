import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n x n !) / O(n x n!)
public class Permutations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = permutations(a);
        for (var perm : res) {
          for (int e : perm) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  private static List<List<Integer>> permutations(int[] a) {
    List<List<Integer>> allPerms = new ArrayList<>();

    Queue<List<Integer>> q = new ArrayDeque<>();
    q.add(new ArrayList<>());

    for (int e : a) {
      int n = q.size();
      for (int i = 0; i < n; i++) {
        List<Integer> currPerm = q.poll();
        for (int j = 0; j <= currPerm.size(); j++) {
          List<Integer> newPerm = new ArrayList<>(currPerm);
          newPerm.add(j, e);

          if (newPerm.size() == a.length) {
            allPerms.add(newPerm);
          } else {
            q.add(newPerm);
          }
        }
      }
    }

    return allPerms;
  }
}