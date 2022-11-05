import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

        System.out.println(fruitsIntoBaskets(a));
      }
    }
  }

  // O(n) / O(1)
  public static int fruitsIntoBaskets(char[] a) {
    Map<Character, Integer> freq = new HashMap<>();
    int maxLen = 0, windowStart = 0;

    for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
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

    return maxLen;
  }
}