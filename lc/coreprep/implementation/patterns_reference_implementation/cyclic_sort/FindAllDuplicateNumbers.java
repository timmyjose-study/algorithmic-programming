import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class FindAllDuplicateNumbers {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        sort(a);

        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          if (a[i] != i + 1) {
            duplicates.add(a[i]);
          }
        }

        for (int d : duplicates) {
          System.out.printf("%d ", d);
        }
        System.out.println();
      }
    }
  }

  private static void sort(int[] a) {
    int i = 0;
    while (i < a.length) {
      if (a[i] != a[a[i] - 1]) {
        swap(a, i, a[i] - 1);
      } else {
        i++;
      }
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }
}