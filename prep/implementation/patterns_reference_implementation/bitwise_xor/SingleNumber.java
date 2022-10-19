import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SingleNumber {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(singleNumber(a));
      }
    }
  }

  // O(n) / O(1)
  public static int singleNumber(int[] a) {
    int xor = 0;
    for (int e : a) {
      xor ^= e;
    }

    return xor;
  }
}