import java.util.Scanner;

public class VanyaAndCards {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();
      int s = 0;

      for (int i = 0; i < n; i++) {
        s += in.nextInt();
      }

      s = Math.abs(s);

      int t = 0;
      for (int d = k; d >= 1; d--) {
        if (s == 0) {
          break;
        }
        t += s / d;
        s %= d;
      }

      System.out.println(t);
    }
  }
}