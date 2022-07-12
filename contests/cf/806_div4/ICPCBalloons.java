import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ICPCBalloons {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();

        int sol = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
          if (!set.contains(c)) {
            sol += 2;
            set.add(c);
          } else {
            sol++;
          }
        }

        System.out.println(sol);
      }
    }
  }
}