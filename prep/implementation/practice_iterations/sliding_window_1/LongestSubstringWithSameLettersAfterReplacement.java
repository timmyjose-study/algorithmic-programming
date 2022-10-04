import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class LongestSubstringWithSameLettersAfterReplacement {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.next().trim();
        int k = in.nextInt();

        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0, windowStart = 0, maxLen = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
          char r = s.charAt(windowEnd);
          freq.put(r, freq.getOrDefault(r, 0) + 1);
          maxFreq = Math.max(maxFreq, freq.get(r));

          while (windowEnd - windowStart + 1 - maxFreq > k) {
            char l = s.charAt(windowStart);
            freq.put(l, freq.get(l) - 1);
            windowStart++;
          }

          maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        System.out.println(maxLen);
      }
    }
  }
}