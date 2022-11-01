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

    int end = 0;
    for (int i = 0; i < a.length; i++) {
      int n = res.size();

      int start = (i > 0 && (a[i] == a[i - 1])) ? end : 0;
      end = n;

      for (int j = start; j < n; j++) {
        List<Integer> currSub = new ArrayList<>(res.get(j));
        currSub.add(a[i]);
        res.add(currSub);
      }
    }

    return res;
  }
}