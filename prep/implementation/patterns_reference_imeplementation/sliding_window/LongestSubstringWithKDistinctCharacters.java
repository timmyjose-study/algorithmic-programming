import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class LongestSubstringWithKDistinctCharacters {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        String s = in.next().trim();
        int k = in.nextInt();

        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          char c = s.charAt(windowEnd);
          freq.put(c, freq.getOrDefault(c, 0) + 1);

          while (freq.size() > k) {
            char d = s.charAt(windowStart);
            freq.put(d, freq.get(d) - 1);

            if (freq.get(d) == 0) {
              freq.remove(d);
            }
            windowStart++;
          }

          maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        System.out.println(maxLen);
      }
    }
  }
}