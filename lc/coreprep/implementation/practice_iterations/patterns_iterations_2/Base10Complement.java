import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Base10Complement {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(complement(n));
      }
    }
  }

  // O(b) / O(1)
  public static int complement(int n) {
    int numBits = 0;
    int m = n;
    while (m > 0) {
      numBits++;
      m >>= 1;
    }

    return n ^ (int)(Math.pow(2, numBits) - 1);
  }
}