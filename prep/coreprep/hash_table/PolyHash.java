import java.util.Scanner;

public class PolyHash {
  // upto 1 << 30
  private static final int PRIME = 1610612741;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      while (n-- > 0) {
        String s = in.nextLine().trim();
        System.out.printf("%d\n", hash(s));
      }
    }
  }

  private static long hash(String s) {
    long x = 53;
    long p = (int)1e9 + 9;
    long xpow = 1;
    long hash = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      hash = (hash + (s.charAt(i) - 'a' + 1) * xpow) % p;
      xpow = (xpow * x) % p;
    }

    return hash;
  }
}