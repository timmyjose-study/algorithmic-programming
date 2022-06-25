import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LLPS {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      var a = in.nextLine().trim().toCharArray();
      List<String> sol = new ArrayList<>();

      for (int i = 0; i < 1<<a.length; i++) {
        var sb = new StringBuffer();
        for (int j = 0; j < a.length; j++) {
          if ((i & (1<<j)) != 0) {
            sb.append(a[j]);
          }
        }

        if (!sb.isEmpty() && isPalindrome(sb)) {
          sol.add(sb.toString());
        }
      }

      Collections.sort(sol, (String s1, String s2) -> {
        var s1len = s1.length();
        var s2len = s2.length();

        for (int i = 0; i < Math.min(s1len, s2len); i++) {
          if (s1.charAt(i) < s2.charAt(i)) {
            return 1;
          } else if (s1.charAt(i) > s2.charAt(i)) {
            return -1;
          } 
        }

        if (s1len < s2len) {
          return 1;
        } else if (s1len > s2len) {
          return -1;
        }

        return 0;
      });

      System.out.println(sol.get(0));
    }
  }

  private static boolean isPalindrome(StringBuffer sb) {
    for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
      if (sb.charAt(i) != sb.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
