import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TwoSingleNumbers {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        int[] res = twoSingleNumbers(a);
        System.out.printf("%d %d\n", res[0], res[1]);
      }
    }
  }

  // O(n) / O(1)
  public static int[] twoSingleNumbers(int[] a) {
    int xor = 0;
    for (int e : a) {
      xor ^= e;
    }

    int pos = 1;
    while ((pos & xor) == 0) {
      pos <<= 1;
    }

    int num1 = 0, num2 = 0;
    for (int e : a) {
      if ((e & pos) != 0) {
        num1 ^= e;
      } else {
        num2 ^= e;
      }
    }

    return new int[] {num1, num2};
  }
}