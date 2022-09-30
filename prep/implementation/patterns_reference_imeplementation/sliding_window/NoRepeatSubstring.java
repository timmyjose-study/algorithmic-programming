import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class NoRepeatSubstring {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();

        int n = s.length();
        Map<Character, Integer> pos = new HashMap<>();
        int maxLen = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          char c = s.charAt(windowEnd);

          if (pos.containsKey(c)) {
            windowStart = Math.max(windowStart, pos.get(c) + 1);
          }

          pos.put(c, windowEnd);
          maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        System.out.println(maxLen);
      }
    }
  }
}