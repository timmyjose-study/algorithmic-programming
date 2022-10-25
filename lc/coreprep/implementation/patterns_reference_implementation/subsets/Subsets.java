import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(2^n) / O(2^n)
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
        for (var sub : res) {
          for (int e : sub) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  private static List<List<Integer>> subsets(int[] a) {
    List<List<Integer>> allSubs = new ArrayList<>();
    allSubs.add(new ArrayList<>());

    for (int e : a) {
      int n = allSubs.size();
      for (int j = 0; j < n; j++) {
        List<Integer> currSub = new ArrayList<>(allSubs.get(j));
        currSub.add(e);
        allSubs.add(currSub);
      }
    }

    return allSubs;
  }
}