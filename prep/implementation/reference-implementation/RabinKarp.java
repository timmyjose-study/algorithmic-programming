import java.util.*;

public class RabinKarp {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String s = in.nextLine().trim();
        String t = in.nextLine().trim();

        List<Integer> occurrences = rabinKarp(s, t);
        if (occurrences.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(occurrences.size());
          for (int pos : occurrences) {
            System.out.printf("%d ", pos);
          }
          System.out.println();
        }
      }
    }
  }

  // O(|s| + |t|)
  private static List<Integer> rabinKarp(String s, String t) {
    long m = 53;
    long p = (long)1e9 + 7;
    int slen = s.length(), tlen = t.length();

    long[] ppow = new long[Math.max(slen, tlen)];
    ppow[0] = 1;
    for (int i = 1; i < ppow.length; i++) {
      ppow[i] = (ppow[i - 1] * p) % m;
    }

    long shash = 0L;
    for (int i = 0; i < slen; i++) {
      shash = (shash + (s.charAt(i) - 'a' + 1) * ppow[i]) % m;
    }

    if (shash < 0) {
      shash += m;
    }

    long[] thashes = new long[tlen + 1];
    for (int i = 0; i < tlen; i++) {
      thashes[i + 1] = (thashes[i] + (t.charAt(i) - 'a' + 1) * ppow[i]) % m;
    }

    for (int i = 0; i < thashes.length; i++) {
      if (thashes[i] < 0) {
        thashes[i] += m;
      }
    }

    List<Integer> occurrences = new ArrayList<>();
    for (int i = 0; i < tlen - slen + 1; i++) {
      long currHash = (thashes[i + slen] + m - thashes[i]) % m;

      if (currHash == shash * ppow[i] % m) {
        occurrences.add(i);
      }
    }

    return occurrences;
  }
}