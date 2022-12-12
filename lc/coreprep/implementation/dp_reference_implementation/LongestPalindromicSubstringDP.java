import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LongestPalindromicSubstringDP {
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

    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
    }

    for (int start = s.length() - 1; start >= 0; start--) {
      for (int end = start + 1; end < s.length(); end++) {
        if (s.charAt(start) == s.charAt(end)) {
          int remLen = end - start - 1;

          if (remLen == dp[start + 1][end - 1]) {
            dp[start][end] = 2 + remLen;
            continue;
          }
        }

        dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
      }
    }

    return dp[0][s.length() - 1];
  }
}