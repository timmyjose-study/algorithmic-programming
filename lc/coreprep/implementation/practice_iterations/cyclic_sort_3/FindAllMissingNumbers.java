import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class FindAllMissingNumbers {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        var res = findAllMissingNumbers(a);
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

  private static List<Integer> findAllMissingNumbers(int[] a) {
    int i = 0;
    int n = a.length;

    while (i < n) {
      if (a[i] != a[a[i] - 1]) {
        swap(a, i, a[i] - 1);
      } else {
        i++;
      }
    }

    List<Integer> missing = new ArrayList<>();
    for (int j = 0; j < n; j++) {
      if (a[j] != j + 1) {
        missing.add(j + 1);
      }
    }

    return missing;
  }
}