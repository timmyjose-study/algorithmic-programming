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