import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class RabinKarp {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String needle = in.nextLine().trim();
        String haystack = in.nextLine().trim();

        var pos = rabinKarp(needle, haystack);
        if (pos.size() > 0) {
          System.out.println(pos.size());
          for (int p : pos) {
            System.out.printf("%d ", p);
          }
          System.out.println();
        } else {
          System.out.println(-1);
        }
      }
    }
  }

  // O(n)
  private static List<Integer> rabinKarp(String s, String t) {
    long m = 53;
    long p = (long)1e9 + 7;

    int slen = s.length();
    int tlen = t.length();

    long[] mpow = new long[Math.max(slen, tlen)];
    mpow[0] = 1;
    for (int i = 1; i < mpow.length; i++) {
      mpow[i] = (mpow[i - 1] * m) % p;
    }

    long shash = 0;
    for (int i = 0; i < slen; i++) {
      shash = (shash + (s.charAt(i) - 'a' + 1) * mpow[i]) % p;
    }

    if (shash < 0) {
      shash += p;
    }

    long[] thashes = new long[tlen + 1];
    for (int i = 0; i < tlen; i++) {
      thashes[i + 1] = (thashes[i] + (t.charAt(i) - 'a' + 1) * mpow[i]) % p;
    }

    for (int i = 0; i <= tlen; i++) {
      if (thashes[i] < 0) {
        thashes[i] += p;
      }
    }

    List<Integer> pos = new ArrayList<>();
    for (int i = 0; i < tlen - slen + 1; i++) {
      long currHash = (thashes[i + slen] + p - thashes[i]) % p;

      if (currHash == shash * mpow[i] % p) {
        pos.add(i);
      }
    }

    return pos;
  }
}