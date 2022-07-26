import java.util.*;

class TestClass {
  public static void main(String args[]) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int x = 0, y = 0;
      String s = in.nextLine().trim();
      for (char c : s.toCharArray()) {
        if (c == 'Z' || c == 'z') {
          x++;
        } else {
          y++;
        }
      }

      if (y == 2 * x) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}