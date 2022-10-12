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

        char[] a = new char[n];
        String[] inp = in.nextLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
          a[i] = inp[i].charAt(0);
        }

        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
          char r = a[windowEnd];
          freq.put(r, freq.getOrDefault(r, 0) + 1);

          while (freq.size() > 2) {
            char l = a[windowStart];
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