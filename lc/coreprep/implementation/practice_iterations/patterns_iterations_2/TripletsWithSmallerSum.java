import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        System.out.println(tripletsWithSmallerSum(a, s));
      }
    }
  }

  // O(n2) / O(1)
  public static int tripletsWithSmallerSum(int[] a, int s) {
    Arrays.sort(a);

    int cnt = 0;
    for (int i = 0; i < a.length - 1; i++) {
      int left = i + 1, right = a.length - 1;

      while (left < right) {
        int sum = a[i] + a[left] + a[right];

        if (sum < s) {
          cnt += right - left;
          left++;
        } else {
          right--;
        }
      }
    }

    return cnt;
  }
}