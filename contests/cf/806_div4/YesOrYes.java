import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class YesOrYes {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String s = in.nextLine();
        if (s.equalsIgnoreCase("YES")) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }
}