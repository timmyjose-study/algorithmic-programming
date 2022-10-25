import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(k)
public class LongestSubstringWithKDistinctCharacters {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.next().trim();
        int k = in.nextInt();

        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
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

        System.out.println(maxLen);
      }
    }
  }
}