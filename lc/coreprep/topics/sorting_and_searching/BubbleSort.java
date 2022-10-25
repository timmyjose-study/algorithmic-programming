import java.util.Scanner;

public class BubbleSort {
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

  // O(N^2) / O(1)
  private static void sort(int[] a, int n) {
    boolean switched = false;
    int t;

    for (int i = 0; i < n; i++) {
      switched = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          t = a[j];
          a[j] = a[j + 1];
          a[j + 1] = t;
          switched = true;
        }
      }

      if (!switched) {
        break;
      }
    }
  }

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }
}