import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LongestPalindromicSubsequenceMemo {
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

  // O(n2) / O(n2)
  public static int lpss(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    Integer[][] dp = new Integer[s.length()][s.length()];
    return lpss(s, 0, s.length() - 1, dp);
  }

  private static int lpss(String s, int startIdx, int endIdx, Integer[][] dp) {
    if (startIdx > endIdx) {
      return 0;
    }

    if (startIdx == endIdx) {
      return 1;
    }

    if (dp[startIdx][endIdx] == null) {
      if (s.charAt(startIdx) == s.charAt(endIdx)) {
        dp[startIdx][endIdx] = 2 + lpss(s, startIdx + 1, endIdx - 1, dp);
      } else {
        dp[startIdx][endIdx] = Math.max(lpss(s, startIdx + 1, endIdx, dp),
                                        lpss(s, startIdx, endIdx - 1, dp));
      }
    }

    return dp[startIdx][endIdx];
  }
}