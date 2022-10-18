import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Combinations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      var combs = combinations(a, k);
      for (var comb : combs) {
        for (int c : comb) {
          System.out.printf("%d ", c);
        }
        System.out.println();
      }
    }
  }

  // O(nCk) / O(nCk)
  public static List<List<Integer>> combinations(int[] a, int k) {
    List<List<Integer>> allCombs = new ArrayList<>();
    combinations(a, 0, new ArrayList<>(), allCombs, k);

    return allCombs;
  }

  private static void combinations(int[] a, int currIdx, List<Integer> currComb,
                                   List<List<Integer>> allCombs, int k) {
    if (currComb.size() == k) {
      allCombs.add(new ArrayList<>(currComb));
      return;
    }

    if (currIdx == a.length) {
      return;
    }

    currComb.add(a[currIdx]);
    combinations(a, currIdx + 1, currComb, allCombs, k);
    currComb.remove(currComb.size() - 1);
    combinations(a, currIdx + 1, currComb, allCombs, k);
  }
}