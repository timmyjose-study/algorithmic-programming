import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class RemoveDuplicates {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int nextPos = 1;
        for (int i = 1; i < n; i++) {
          if (a[nextPos - 1] != a[i]) {
            a[nextPos++] = a[i];
          }
        }

        int len = nextPos;

        System.out.println(len);
        for (int i = 0; i < len; i++) {
          System.out.printf("%d ", a[i]);
        }
        System.out.println();
      }
    }
  }
}