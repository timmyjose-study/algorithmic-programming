import java.util.Scanner;

public class Cakeminator {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int r = in.nextInt();
      int c = in.nextInt();
      in.nextLine();
      char a[][] = new char[r][c];

      for (int i = 0; i < r; i++) {
        String row = in.nextLine().trim();
        for (int j = 0; j < c; j++) {
          a[i][j] = row.charAt(j);
        }
      }

      int count = 0;
      for (int i = 0; i < r; i++) {
        boolean okay = true;
        for (int j = 0; j < c; j++) {
          if (a[i][j] == 'S') {
            okay = false;
            break;
          }
        }

        if (okay) {
          for (int j = 0; j < c; j++) {
            if (a[i][j] == '.') {
              count++;
              a[i][j] = 'X';
            }
          }
        }
      }

      for (int j = 0; j < c; j++) {
        boolean okay = true;
        for (int i = 0; i < r; i++) {
          if (a[i][j] == 'S') {
            okay = false;
            break;
          }
        }

        if (okay) {
          for (int i = 0; i < r; i++) {
            if (a[i][j] == '.') {
              count++;
              a[i][j] = 'X';
            }
          }
        }
      }

      System.out.println(count);
    }
  }
}