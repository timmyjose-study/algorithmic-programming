import java.util.*;

public class PolyHash {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String s = in.nextLine().trim();
        System.out.printf("%d\n", polyHash(s));
      }
    }
  }

  // O(n)
  private static long polyHash(String s) {
    long x = 53;
    long p = (long)1e9 + 7;
    long xpow = 1;
    long hash = 0L;

    for (int i = s.length() - 1; i >= 0; i--) {
      hash = (hash + (s.charAt(i) - 'a' + 1) * xpow) % p;
      xpow = (xpow * x) % p;
    }

    return hash;
  }
}