import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TheClock {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- != 0) {
        String[] s = in.nextLine().split("[ \t]");
        int h1 = s[0].charAt(0) - '0';
        int h2 = s[0].charAt(1) - '0';
        int m1 = s[0].charAt(3) - '0';
        int m2 = s[0].charAt(4) - '0';
        int d = Integer.parseInt(s[1]);

        int sol = 0, cnt = 0;
        Set<String> ps = new HashSet<>();
        for (int i = 0;; i += d) {
          cnt++;
          int tot = ((h1 * 10 + h2) * 60 + (10 * m1 + m2) + i) % 1440;

          int hrs = tot / 60;
          int hh2 = hrs % 10;
          int hh1 = hrs < 10 ? 0 : (hrs / 10) % 10;

          int mins = tot % 60;
          int mm2 = mins % 10;
          int mm1 = mins < 10 ? 0 : (mins / 10) % 10;

          if (isPalindrome(hh1, hh2, mm1, mm2)) {
            String key = "" + hh1 + hh2 + mm1 + mm2;
            if (ps.contains(key)) {
              break;
            }
            ps.add(key);
            sol++;
          }

          if (cnt > 1440) {
            break;
          }
        }

        System.out.println(sol);
      }
    }
  }

  private static boolean isPalindrome(int h1, int h2, int m1, int m2) {
    return (h1 == m2) && (h2 == m1);
  }
}