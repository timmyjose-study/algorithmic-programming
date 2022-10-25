import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n3) / O(1)
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

        Arrays.sort(a);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
          int left = i + 1, right = n - 1;

          while (left < right) {
            int sum = a[i] + a[left] + a[right];

            if (sum < s) {
              List<Integer> tmp = new LinkedList<>();
              for (int j = right; j > left; j--) {
                res.add(Arrays.asList(a[i], a[left], a[j]));
              }
              left++;
            } else {
              right--;
            }
          }
        }

        for (var sub : res) {
          for (int e : sub) {
            System.out.printf("%d ", e);
          }
          System.out.println();
        }
      }
    }
  }
}