import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class KthLargestNumberBrute {
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

        System.out.println(kthLargestNumber(a, n, k));
      }
    }
  }

  // O(nk) / O(1)
  public static int kthLargestNumber(int[] a, int n, int k) {
    int prevLargest = Integer.MAX_VALUE;
    int prevLargestIdx = -1;
    int currLargest = Integer.MIN_VALUE;
    int currLargestIdx = -1;

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < n; j++) {
        if (a[j] < prevLargest && a[j] > currLargest ||
            a[j] == prevLargest && j > prevLargestIdx) {
          currLargest = a[j];
          currLargestIdx = j;
        }
      }

      prevLargest = currLargest;
      prevLargestIdx = currLargestIdx;
      currLargest = Integer.MIN_VALUE;
    }

    return prevLargest;
  }
}