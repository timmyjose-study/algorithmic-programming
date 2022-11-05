import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(n x n!) / O(n x n!)
  public static List<List<Integer>> permutations(int[] a) {
    List<List<Integer>> res = new ArrayList<>();

    Queue<List<Integer>> q = new ArrayDeque<>();
    q.add(new ArrayList<>());

    for (int e : a) {
      int qsize = q.size();

      for (int i = 0; i < qsize; i++) {
        var curr = q.poll();

        int currSize = curr.size();
        for (int j = 0; j <= currSize; j++) {
          List<Integer> next = new LinkedList<>(curr);
          next.add(j, e);

          if (next.size() == a.length) {
            res.add(next);
          } else {
            q.add(next);
          }
        }
      }
    }

    return res;
  }
}