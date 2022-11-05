import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TripletSumToZero {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = tripletSumToZero(a);
        for (var r : res) {
          for (var e : r) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }

  // O(n2) / O(n)
  public static List<List<Integer>> tripletSumToZero(int[] a) {
    Arrays.sort(a);

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < a.length - 1; i++) {
      int left = i + 1, right = a.length - 1;
      while (left < right) {
        int sum = a[i] + a[left] + a[right];

        if (sum == 0) {
          res.add(Arrays.asList(a[i], a[left], a[right]));
          left++;
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }

    return res;
  }
}