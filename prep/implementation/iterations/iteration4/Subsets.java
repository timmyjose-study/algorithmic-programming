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

  // O(n * 2^n) / O(n)
  private static List<List<Integer>> subsets(int[] a, int n) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets(a, n, 0, new ArrayList<>(), subsets);

    return subsets;
  }

  private static void subsets(int[] a, int n, int currIdx, List<Integer> sub,
                              List<List<Integer>> subsets) {
    if (currIdx == n) {
      List<Integer> tmp = new ArrayList<>();
      for (int s : sub) {
        tmp.add(s);
      }

      subsets.add(tmp);
      return;
    }

    sub.add(a[currIdx]);
    subsets(a, n, currIdx + 1, sub, subsets);
    sub.remove(sub.size() - 1);
    subsets(a, n, currIdx + 1, sub, subsets);
  }

  // O(n * 2^n) / O(n)
  private static List<List<Integer>> subsetsBitmask(int[] a, int n) {
    List<List<Integer>> subsets = new ArrayList<>();

    for (int i = 0; i < (1 << n); i++) {
      List<Integer> sub = new ArrayList<>();

      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          sub.add(a[j]);
        }
      }
      subsets.add(sub);
    }

    return subsets;
  }
}