import java.util.Scanner;

public class Squats {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      String s = in.nextLine().trim();
      int d = 0, u = 0;
      for (char c : s.toCharArray()) {
        if (c == 'x') {
          d++;
        } else {
          u++;
        }
      }

      if (d == u) {
        System.out.println(0);
        System.out.println(s);
      } else {
        StringBuffer sb = new StringBuffer(s);

        if (d < u) {
          int m = n / 2 - d;
          System.out.println(m);

          int i = 0;
          while (m != 0) {
            if (s.charAt(i) == 'X') {
              sb.setCharAt(i, 'x');
              m--;
            }
            i++;
          }

          System.out.println(sb.toString());
        } else {
          int m = n / 2 - u;
          System.out.println(m);

          int i = 0;
          while (m != 0) {
            if (s.charAt(i) == 'x') {
              sb.setCharAt(i, 'X');
              m--;
            }
            i++;
          }

          System.out.println(sb.toString());
        }
      }
    }
  }
}