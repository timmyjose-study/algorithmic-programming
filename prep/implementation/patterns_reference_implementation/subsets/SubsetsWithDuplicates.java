import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(2^n) / O(2^n)
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
        for (var sub : res) {
          for (int e : sub) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  private static List<List<Integer>> subsetsWithDuplicates(int[] a) {
    Arrays.sort(a);

    List<List<Integer>> allSubs = new ArrayList<>();
    allSubs.add(new ArrayList<>());

    int startPos = 0;
    for (int i = 0; i < a.length; i++) {
      int currStartPos = (i > 0 && (a[i] == a[i - 1])) ? startPos : 0;

      int n = allSubs.size();
      for (int j = currStartPos; j < n; j++) {
        List<Integer> currSub = new ArrayList<>(allSubs.get(j));
        currSub.add(a[i]);
        allSubs.add(currSub);
      }
      startPos = n;
    }

    return allSubs;
  }
}