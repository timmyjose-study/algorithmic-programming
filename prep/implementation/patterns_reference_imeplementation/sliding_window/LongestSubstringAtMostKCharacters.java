import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n)
public class LongestSubstringAtMostKCharacters {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.next();
        int n = s.length();
        int k = in.nextInt();

        int maxLen = 0;
        Map<Character, Integer> m = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          char c = s.charAt(windowEnd);
          m.put(c, m.getOrDefault(c, 0) + 1);

          while (m.size() > k) {
            char d = s.charAt(windowStart);
            m.put(d, m.get(d) - 1);
            if (m.get(d) == 0) {
              m.remove(d);
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