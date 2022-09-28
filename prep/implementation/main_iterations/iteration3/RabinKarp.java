import java.util.*;

public class RabinKarp {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String needle = in.nextLine().trim();
        String haystack = in.nextLine().trim();

        List<Integer> positions = rabinKarp(needle, haystack);
        if (positions.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(positions.size());
          for (int pos : positions) {
            System.out.printf("%d ", pos);
          }
          System.out.println();
        }
      }
    }
  }

  // O(|needle| + |haystack|)
  private static List<Integer> rabinKarp(String s, String t) {
    long x = 53;
    long p = (long)1e9 + 7;
    int slen = s.length(), tlen = t.length();

    long[] xpow = new long[Math.max(slen, tlen)];
    xpow[0] = 1L;
    for (int i = 1; i < xpow.length; i++) {
      xpow[i] = (xpow[i - 1] * x) % p;
    }

    long shash = 0L;
    for (int i = 0; i < slen; i++) {
      shash = (shash + (s.charAt(i) - 'a' + 1) * xpow[i]) % p;
    }

    if (shash < 0) {
      shash += p;
    }

    long[] thashes = new long[tlen + 1];
    for (int i = 0; i < tlen; i++) {
      thashes[i + 1] = (thashes[i] + (t.charAt(i) - 'a' + 1) * xpow[i]) % p;
    }

    for (int i = 0; i < thashes.length; i++) {
      if (thashes[i] < 0) {
        thashes[i] += p;
      }
    }

    List<Integer> positions = new ArrayList<>();
    for (int i = 0; i < tlen - slen + 1; i++) {
      long currHash = (thashes[i + slen] + p - thashes[i]) % p;

      if (currHash == (shash * xpow[i] % p)) {
        positions.add(i);
      }
    }

    return positions;
  }
}