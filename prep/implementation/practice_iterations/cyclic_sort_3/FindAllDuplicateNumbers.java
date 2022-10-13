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

        var res = findAllDuplicateNumbers(a);
        for (int e : res) {
          System.out.printf("%d ", e);
        }
        System.out.println();
      }
    }
  }

  private static void swap(int[] a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  private static List<Integer> findAllDuplicateNumbers(int[] a) {
    int i = 0;
    int n = a.length;

    List<Integer> duplicates = new ArrayList<>();
    while (i < n) {
      if (a[i] != i + 1) {
        if (a[i] != a[a[i] - 1]) {
          swap(a, i, a[i] - 1);
        } else {
          duplicates.add(a[i]);
          i++;
        }
      } else {
        i++;
      }
    }

    return duplicates;
  }
}