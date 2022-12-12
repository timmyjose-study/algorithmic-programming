import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class CountOfPalindromicSubstringsBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        System.out.println(countPalindromes(s));
      }
    }
  }

  public static int countPalindromes(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    return countPalindromes(s, 0, s.length() - 1);
  }

  // O(3n) / O(n)
  private static int countPalindromes(String s, int startIdx, int endIdx) {
    if (startIdx > endIdx) {
      return 0;
    }

    if (startIdx == endIdx) {
      return 1;
    }

    int cnt = 0;

    if (isPalindrome(s, startIdx, endIdx)) {
      cnt++;
    }

    cnt += countPalindromes(s, startIdx + 1, endIdx);
    cnt += countPalindromes(s, startIdx, endIdx - 1);
    cnt -= countPalindromes(s, startIdx + 1, endIdx - 1);

    return cnt;
  }

  private static boolean isPalindrome(String s, int startIdx, int endIdx) {
    while (startIdx < endIdx) {
      if (s.charAt(startIdx) != s.charAt(endIdx)) {
        return false;
      }
      startIdx++;
      endIdx--;
    }
    return true;
  }
}