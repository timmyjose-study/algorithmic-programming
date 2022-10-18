import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthSmallestNumberBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(kthSmallestNumber(a, n, k));
      }
    }
  }

  // O(nk) / O(1)
  public static int kthSmallestNumber(int[] a, int n, int k) {
    int prevSmallest = Integer.MIN_VALUE;
    int prevSmallestIdx = -1;
    int currSmallest = Integer.MAX_VALUE;
    int currSmallestIdx = -1;

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < n; j++) {
        if (a[j] > prevSmallest && a[j] < currSmallest ||
            a[j] == prevSmallest && j > prevSmallestIdx) {
          currSmallest = a[j];
          currSmallestIdx = j;
        }
      }
      prevSmallest = currSmallest;
      prevSmallestIdx = currSmallestIdx;
      currSmallest = Integer.MAX_VALUE;
    }

    return prevSmallest;
  }
}