import java.util.Scanner;

public class SelectionSort {
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
    int maxpos = -1;
    int t;

    for (int i = n - 1; i > 0; i--) {
      maxpos = i;
      for (int j = i - 1; j >= 0; j--) {
        if (a[j] > a[maxpos]) {
          maxpos = j;
        }
      }

      if (maxpos != i) {
        t = a[i];
        a[i] = a[maxpos];
        a[maxpos] = t;
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