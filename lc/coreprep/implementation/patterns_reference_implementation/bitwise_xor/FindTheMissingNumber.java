import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FindTheMissingNumber {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
          a[i] = in.nextInt();
        }

        System.out.println(missingNumber(a));
      }
    }
  }

  // O(n) / O(1)
  public static int missingNumber(int[] a) {
    int xor1 = 0;
    for (int i = 1; i <= a.length + 1; i++) {
      xor1 ^= i;
    }

    int xor2 = 0;
    for (int e : a) {
      xor2 ^= e;
    }

    return xor1 ^ xor2;
  }
}