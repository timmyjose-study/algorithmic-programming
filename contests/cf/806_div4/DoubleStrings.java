import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DoubleStrings {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();

        List<String> allStrings = new ArrayList<>();
        Set<String> allStringsSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
          String s = in.nextLine().trim();
          allStrings.add(s);
          allStringsSet.add(s);
        }

        StringBuffer sol = new StringBuffer();
        for (int i = 0; i < n; i++) {
          String s = allStrings.get(i);
          int len = s.length();
          boolean done = false;

          for (int j = 1; j < len; j++) {
            String s1 = s.substring(0, j);
            String s2 = s.substring(j, len);

            if (allStringsSet.contains(s1) && allStringsSet.contains(s2)) {
              sol.append("1");
              done = true;
              break;
            }
          }

          if (!done) {
            sol.append("0");
          }
        }

        System.out.println(sol.toString());
      }
    }
  }
}