import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int q = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a, n);
      Arrays.sort(a);
      display(a, n);

      int elem, idx;
      for (int i = 0; i < q; i++) {
        elem = in.nextInt();

        System.out.println(binarySearch(a, 0, n - 1, elem));
        System.out.println(binarySearchRec(a, 0, n - 1, elem));
      }
    }
  }

  // O(logN)
  private static int binarySearch(int[] a, int low, int high, int elem) {
    int mid = -1;

    while (low <= high) {
      mid = low + (high - low) / 2;

      if (a[mid] < elem) {
        low = mid + 1;
      } else if (a[mid] > elem) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  // O(logN)
  private static int binarySearchRec(int[] a, int low, int high, int elem) {
    if (low > high) {
      return -1;
    }

    int mid = low + (high - low) / 2;

    if (a[mid] < elem) {
      return binarySearch(a, mid + 1, high, elem);
    } else if (a[mid] > elem) {
      return binarySearch(a, low, mid - 1, elem);
    }

    return mid;
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}