import java.util.*;

public class InsertionSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      display(a, n);
      sort(a, n);
      display(a, n);
    }
  }

  private static void sort(int[] a, int n) {
    for (int i = 1; i < n; i++) {
      int k = a[i];
      int j = i - 1;

      while (j >= 0 && a[j] > k) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = k;
    }
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}