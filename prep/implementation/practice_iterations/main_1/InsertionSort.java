import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

  // O(n^2)
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

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}