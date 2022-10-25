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
    int bitCount = 0;
    int num = n;

    while (num > 0) {
      bitCount++;
      num >>= 1;
    }

    int allSetBits = (int)Math.pow(2, bitCount) - 1;

    return n ^ allSetBits;
  }
}