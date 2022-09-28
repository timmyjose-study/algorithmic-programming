import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n)
public class FruitsIntoBaskets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
          a[i] = in.next().charAt(0);
        }

        Map<Character, Integer> m = new HashMap<>();
        int maxLen = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          m.put(a[windowEnd], m.getOrDefault(a[windowEnd], 0) + 1);

          while (m.size() > 2) {
            m.put(a[windowStart], m.get(a[windowStart]) - 1);
            if (m.get(a[windowStart]) == 0) {
              m.remove(a[windowStart]);
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