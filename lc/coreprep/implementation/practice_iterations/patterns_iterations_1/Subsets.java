import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Subsets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = subsets(a);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(2n) / O(2n)
  public static List<List<Integer>> subsets(int[] a) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    for (int e : a) {
      int n = res.size();
      for (int i = 0; i < n; i++) {
        List<Integer> newSub = new ArrayList<>(res.get(i));
        newSub.add(e);
        res.add(newSub);
      }
    }

    return res;
  }
}