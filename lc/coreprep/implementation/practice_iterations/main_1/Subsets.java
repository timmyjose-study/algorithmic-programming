import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Subsets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      subsets(a);
      subsetsBitwise(a);
    }
  }

  // O(2^n) / O(n x 2^n)
  public static void subsets(int[] a) {
    List<List<Integer>> allSubs = new ArrayList<>();
    subsets(a, 0, new ArrayList<>(), allSubs);

    for (var sub : allSubs) {
      for (int s : sub) {
        System.out.printf("%d ", s);
      }
      System.out.println();
    }
  }

  private static void subsets(int[] a, int currIdx, List<Integer> currSub,
                              List<List<Integer>> allSubs) {
    if (currIdx == a.length) {
      allSubs.add(new ArrayList<>(currSub));
    } else {
      currSub.add(a[currIdx]);
      subsets(a, currIdx + 1, currSub, allSubs);
      currSub.remove(currSub.size() - 1);
      subsets(a, currIdx + 1, currSub, allSubs);
    }
  }

  // O(2^n) / O(n x 2^n)
  public static void subsetsBitwise(int[] a) {
    List<List<Integer>> allSubs = new ArrayList<>();

    for (int i = 0; i < (1 << a.length); i++) {
      List<Integer> currSub = new ArrayList<>();
      for (int j = 0; j < a.length; j++) {
        if ((i & (1 << j)) != 0) {
          currSub.add(a[j]);
        }
      }
      allSubs.add(currSub);
    }

    for (var sub : allSubs) {
      for (int s : sub) {
        System.out.printf("%d ", s);
      }
      System.out.println();
    }
  }
}