import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n)
public class NoRepeatSubstring {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine();

        Map<Character, Integer> m = new HashMap<>();
        int maxLen = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
          char c = s.charAt(windowEnd);

          if (m.containsKey(c)) {
            windowStart = Math.max(windowStart, m.get(c) + 1);
          }

          m.put(c, windowEnd);
          maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        System.out.println(maxLen);
      }
    }
  }
}