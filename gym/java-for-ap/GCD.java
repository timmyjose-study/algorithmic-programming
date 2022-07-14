import java.util.Scanner;
import java.math.BigInteger;

public class GCD {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      BigInteger n = BigInteger.valueOf(in.nextInt());
      BigInteger m = BigInteger.valueOf(in.nextInt());

      System.out.printf("GCD(%d, %d) = %d\n", n, m, n.gcd(m).intValue());
    }
  }
}

