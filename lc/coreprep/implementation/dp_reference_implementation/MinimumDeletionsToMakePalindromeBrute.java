import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MinimumDeletionsToMakePalindromeBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        System.out.println(minDeletions(s));
      }
    }
  }

  // O(3n) / O(n)
  public static int minDeletions(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    int lpssLen = lpss(s, 0, s.length() - 1);
    return s.length() - lpssLen;
  }

  private static int lpss(String s, int startIdx, int endIdx) {
    if (startIdx > endIdx) {
      return 0;
    }

    if (startIdx == endIdx) {
      return 1;
    }

    if (s.charAt(startIdx) == s.charAt(endIdx)) {
      return 2 + lpss(s, startIdx + 1, endIdx - 1);
    }

    return Math.max(lpss(s, startIdx + 1, endIdx),
                    lpss(s, startIdx, endIdx - 1));
  }
}