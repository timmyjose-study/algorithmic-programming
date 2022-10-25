import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n^2) / O(n)
public class TripletsWithSmallerSum {
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

        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
          int left = i + 1, right = n - 1;

          while (left < right) {
            if (a[i] + a[left] + a[right] < s) {
              cnt += right - left;
              left++;
            } else {
              right--;
            }
          }
        }

        System.out.println(cnt);
      }
    }
  }
}