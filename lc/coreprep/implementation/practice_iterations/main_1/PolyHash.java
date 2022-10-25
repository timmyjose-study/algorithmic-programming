import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class PolyHash {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String s = in.nextLine().trim();
        System.out.println(hash(s));
      }
    }
  }

  // O(n)
  private static long hash(String s) {
    long m = 53;
    long p = (long)1e9 + 7;
    long mpow = 1;

    long hash = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      hash = (hash + (s.charAt(i) - 'a' + 1) * mpow) % p;
      mpow = (mpow * m) % p;
    }

    return hash;
  }
}