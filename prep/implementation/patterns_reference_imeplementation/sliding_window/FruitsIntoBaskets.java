import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n) / O(1)
public class FruitsIntoBaskets {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();

        String[] parts = in.nextLine().trim().split(" ");
        char[] a = new char[n];

        for (int i = 0; i < n; i++) {
          a[i] = parts[i].charAt(0);
        }

        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          char c = a[windowEnd];
          freq.put(c, freq.getOrDefault(c, 0) + 1);

          while (freq.size() > 2) {
            char d = a[windowStart];
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