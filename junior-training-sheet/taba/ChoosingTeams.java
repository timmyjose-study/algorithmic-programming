import java.util.Scanner;

public class ChoosingTeams {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int k = in.nextInt();

      int c = 0;
      for (int i = 0; i < n; i++) {
        int d = in.nextInt();
        if ((5 - d) >= k) {
          c++;
        }
      }

      System.out.println(c / 3);
    }
  }
}