import java.util.function.BiFunction;
import java.util.function.Function;

public class Binary {
  public static void main(String[] args) {
    decimalToBinary();
    testKthBitSet();
    setKthBit();
    turnOffKthBit();
    toggleKthBit();
    multiplyBy2PowK();
    divideBy2PowK();
    checkNumberIsPowerOf2();
    swapUnsignedIntegers();
  }

  private static void decimalToBinary() {
    Function<Integer, String> dec2bin = (n) -> {
      StringBuffer sb = new StringBuffer();

      while (n != 0) {
        sb.append(n % 2);
        n >>= 1;
      }

      for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
        char t = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, t);
      }

      return sb.toString();
    };

    for (int i = 1; i <= 10; i++) {
      System.out.printf("%d = %s in binary\n", i, dec2bin.apply(i));
    }
  }

  private static String dec2bin(int n) {
    StringBuffer sb = new StringBuffer();

    while (n > 0) {
      sb.append(n % 2);
      n >>= 1;
    }

    for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
      char t = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(j));
      sb.setCharAt(j, t);
    }

    return sb.toString();
  }

  private static void testKthBitSet() {
    int n = 203;
    for (int i = 0; i < 8; i++) {
      System.out.printf("%s: %dth bit is %s\n", dec2bin(n), i,
                        (n & (1 << i)) != 0 ? "set" : "not set");
    }
  }

  private static void setKthBit() {
    int n = 203;

    System.out.printf("%d in binary = %s\n", n, dec2bin(n));
    System.out.printf("Setting bits 1, 2, and 5 in %d...", n);

    n |= (1 << 1);
    n |= (1 << 2);
    n |= (1 << 5);

    System.out.printf("%d in binary = %s\n", n, dec2bin(n));
  }

  private static void turnOffKthBit() {
    int n = 203;
    System.out.printf("%d in binary = %s\n", n, dec2bin(n));

    n |= (1 << 2);
    n |= (1 << 5);

    System.out.printf(
        "After setting on bits 2 and 5, n = %d which is %s in binary\n", n,
        dec2bin(n));

    n &= ~(1 << 2);
    n &= ~(1 << 5);

    System.out.printf(
        "After turning off bits 2 and 5, n = %d, which is %s in binary\n", n,
        dec2bin(n));
  }

  private static void toggleKthBit() {
    int n = 203;

    System.out.printf("%d in binary = %s\n", n, dec2bin(n));

    System.out.println("Toggling bits 1, 2, and 5");

    n ^= (1 << 1);
    n ^= (1 << 2);
    n ^= (1 << 5);

    System.out.printf("After toggling, n = %d, which is %s in binary\n", n,
                      dec2bin(n));

    System.out.println("Toggling bits 1, 2, and 5 again...");

    n ^= (1 << 1);
    n ^= (1 << 2);
    n ^= (1 << 5);

    System.out.printf("After re-toggling, n = %d, which is %s in binary\n", n,
                      dec2bin(n));
  }

  public static void multiplyBy2PowK() {
    int n = 11;

    for (int i = 0; i < 5; i++) {
      System.out.printf("%d x %d = %d\n", n, (int)Math.pow(2, i), (n << i));
    }
  }

  public static void divideBy2PowK() {
    int n = 11;

    for (int i = 0; i < 5; i++) {
      System.out.printf("%d / %d = %d\n", n, (int)Math.pow(2, i), (n >> i));
    }
  }

  public static void checkNumberIsPowerOf2() {
    for (int i = 0; i <= 32; i++) {
      System.out.printf("%d: %s\n", i,
                        (i & (i - 1)) == 0 ? "power of 2" : "not a power of 2");
    }
  }

  public static void swapUnsignedIntegers() {
    int a = 11, b = 22;

    System.out.printf("Before swapping, a = %d, b = %d\n", a, b);

    a ^= b;
    b ^= a;
    a ^= b;

    System.out.printf("After swapping, a = %d, b = %d\n", a, b);
  }
}