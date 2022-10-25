import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n2) / O(1)
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

        sort(a);

        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
          int left = i + 1, right = n - 1;

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

        System.out.println(cnt);
      }
    }
  }

  private static void sort(int[] a) { sort(a, 0, a.length - 1); }

  private static void sort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int r = ThreadLocalRandom.current().nextInt(high - low + 1) + low;
    swap(a, low, r);

    int mid = partition(a, low, high);
    sort(a, low, mid - 1);
    sort(a, mid + 1, high);
  }

  private static int partition(int[] a, int low, int high) {
    int pivot = a[low];
    int j = low;

    for (int i = low + 1; i <= high; i++) {
      if (a[i] <= pivot) {
        j++;

        if (i != j) {
          swap(a, i, j);
        }
      }
    }

    if (low != j) {
      swap(a, low, j);
    }

    return j;
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}