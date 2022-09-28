import java.util.*;

public class Subsets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      List<List<Integer>> subsets = subsets(a, n);
      for (List<Integer> subset : subsets) {
        for (int s : subset) {
          System.out.printf("%d ", s);
        }
        System.out.println();
      }

      subsets = subsetsBitmask(a, n);
      for (List<Integer> subset : subsets) {
        for (int s : subset) {
          System.out.printf("%d ", s);
        }
        System.out.println();
      }
    }
  }

  public static List<List<Integer>> subsets(int[] a, int n) {
    List<List<Integer>> subs = new ArrayList<>();
    subsets(a, 0, n, new ArrayList<>(), subs);

    return subs;
  }

  private static void subsets(int[] a, int currIdx, int n,
                              List<Integer> currSub, List<List<Integer>> subs) {
    if (currIdx == n) {
      List<Integer> tmp = new ArrayList<>();
      for (int s : currSub) {
        tmp.add(s);
      }
      subs.add(tmp);
    } else {
      currSub.add(a[currIdx]);
      subsets(a, currIdx + 1, n, currSub, subs);
      currSub.remove(currSub.size() - 1);
      subsets(a, currIdx + 1, n, currSub, subs);
    }
  }

  public static List<List<Integer>> subsetsBitmask(int[] a, int n) {
    List<List<Integer>> subs = new ArrayList<>();

    for (int i = 0; i < (1 << n); i++) {
      List<Integer> currSub = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          currSub.add(a[j]);
        }
      }
      subs.add(currSub);
    }

    return subs;
  }
}