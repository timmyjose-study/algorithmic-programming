import java.util.*;

public class CountingSort {
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

  private static void display(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }

  // O(|mn| + |mx| + n) / O(|mm| + |mx|)
  private static void sort(int[] a, int n) {
    int mn = a[0], mx = a[0];

    for (int i = 1; i < n; i++) {
      mn = Math.min(mn, a[i]);
      mx = Math.max(mx, a[i]);
    }

    int k = mx - mn + 1;
    int[] freq = new int[k];

    for (int e : a) {
      freq[e - mn]++;
    }

    int idx = 0, elem = 0;
    for (int f : freq) {
      while (f-- > 0) {
        a[idx++] = elem + mn;
      }
      elem++;
    }
  }
}