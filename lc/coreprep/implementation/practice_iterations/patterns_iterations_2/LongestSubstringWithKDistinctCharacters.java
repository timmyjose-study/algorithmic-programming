import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LongestSubstringWithKDistinctCharacters {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.next();
        int k = in.nextInt();

        System.out.println(longestSubstringWithKDistinctCharacters(s, k));
      }
    }
  }

  // O(n) / O(k)
  public static int longestSubstringWithKDistinctCharacters(String s, int k) {
    Map<Character, Integer> freq = new HashMap<>();
    int windowStart = 0, maxLen = Integer.MIN_VALUE;

    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      char r = s.charAt(windowEnd);
      freq.put(r, freq.getOrDefault(r, 0) + 1);

      while (freq.size() > k) {
        char l = s.charAt(windowStart);
        freq.put(l, freq.get(l) - 1);

        if (freq.get(l) == 0) {
          freq.remove(l);
        }

        windowStart++;
      }

      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }

    return maxLen;
  }
}