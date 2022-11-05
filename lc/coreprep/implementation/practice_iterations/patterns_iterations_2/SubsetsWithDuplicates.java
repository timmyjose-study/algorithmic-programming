import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SubsetsWithDuplicates {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = subsetsWithDuplicates(a);
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
  public static List<List<Integer>> subsetsWithDuplicates(int[] a) {
    Arrays.sort(a);

    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    int prev = 0;
    for (int i = 0; i < a.length; i++) {
      int start = (i > 0 && (a[i] == a[i - 1])) ? prev : 0;
      prev = res.size();

      int size = res.size();
      for (int j = start; j < size; j++) {
        List<Integer> curr = new ArrayList<>(res.get(j));
        curr.add(a[i]);
        res.add(curr);
      }
    }

    return res;
  }
}