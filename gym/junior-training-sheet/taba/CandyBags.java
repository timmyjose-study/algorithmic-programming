import java.util.Scanner;

public class CandyBags {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int l = 1;
      int h = n * n;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
          System.out.printf("%d %d ", l, h);
          l++;
          h--;
        }
        System.out.println();
      }
    }
  }
}
