import java.util.Scanner;

public class VanyaAndFence {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int h = in.nextInt();
      int r = 0;

      for (int i = 0; i < n; i++) {
        int d = in.nextInt();
        if (d > h) {
          r += 2;
        } else {
          r++;
        }
      }
      System.out.println(r);
    }
  }
}