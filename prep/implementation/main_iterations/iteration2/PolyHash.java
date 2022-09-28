import java.util.*;

public class PolyHash {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String s = in.nextLine().trim();
        System.out.println(polyHash(s));
      }
    }
  }

  public static long polyHash(String s) {
    long p = (long)1e9 + 7L;
    long m = 53L;
    long mpow = 1L;

    long hash = 0L;
    for (int i = s.length() - 1; i >= 0; i--) {
      hash = (hash + (s.charAt(i) - 'a' + 1) * mpow) % p;
      mpow = (mpow * m) % p;
    }

    return hash;
  }
}