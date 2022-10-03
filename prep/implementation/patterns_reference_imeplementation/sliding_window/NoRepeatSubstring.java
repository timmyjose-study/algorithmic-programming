import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NoRepeatSubstring {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();

        Map<Character, Integer> pos = new HashMap<>();
        int windowStart = 0, maxLen = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
          char r = s.charAt(windowEnd);

          if (pos.containsKey(r)) {
            windowStart = Math.max(windowStart, pos.get(r) + 1);
          }

          pos.put(r, windowEnd);
          maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        System.out.println(maxLen);
      }
    }
  }
}