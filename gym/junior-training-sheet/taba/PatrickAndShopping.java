import java.util.Scanner;

public class PatrickAndShopping {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int d1 = in.nextInt();
      int d2 = in.nextInt();
      int d3 = in.nextInt();

      int sol =
          Math.min(Math.min(d1 + d3 + d2, 2 * d1 + 2 * d2), Math.min(2 * (d1 + d3), 2 * (d2 + d3)));
      System.out.println(sol);
    }
  }
}