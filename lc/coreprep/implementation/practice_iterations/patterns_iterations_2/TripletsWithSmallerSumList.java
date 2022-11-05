import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TripletsWithSmallerSumList {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = tripletsWithSmallerSum(a, s);
        for (var r : res) {
          for (int e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(n3) / O(1)
  public static List<List<Integer>> tripletsWithSmallerSum(int[] a, int s) {
    Arrays.sort(a);

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < a.length - 1; i++) {
      int left = i + 1, right = a.length - 1;

      while (left < right) {
        int sum = a[i] + a[left] + a[right];

        if (sum < s) {
          for (int j = right; j > left; j--) {
            List<Integer> triplet = Arrays.asList(a[i], a[left], a[j]);
            res.add(triplet);
          }
          left++;
        } else {
          right--;
        }
      }
    }

    return res;
  }
}