import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LongestPalindromicSubstringBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        System.out.println(lpss(s));
      }
    }
  }

  // O(2n) / O(n)
  public static int lpss(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    return lpss(s, 0, s.length() - 1);
  }

  private static int lpss(String s, int startIdx, int endIdx) {
    if (startIdx > endIdx) {
      return 0;
    }

    if (startIdx == endIdx) {
      return 1;
    }

    if (s.charAt(startIdx) == s.charAt(endIdx)) {
      int remLen = endIdx - startIdx - 1;
      if (remLen == lpss(s, startIdx + 1, endIdx - 1)) {
        return 2 + remLen;
      }
    }
    int max1 = lpss(s, startIdx + 1, endIdx);
    int max2 = lpss(s, startIdx, endIdx - 1);

    return Math.max(max1, max2);
  }
}