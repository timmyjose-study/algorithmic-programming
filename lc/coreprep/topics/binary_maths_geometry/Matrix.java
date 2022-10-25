import java.util.Scanner;

public class Matrix {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nrow1 = in.nextInt();
      int ncol1 = in.nextInt();

      int[][] A = new int[nrow1][ncol1];
      for (int i = 0; i < nrow1; i++) {
        for (int j = 0; j < ncol1; j++) {
          A[i][j] = in.nextInt();
        }
      }

      display(A);
      System.out.println();

      int[][] t = transpose(A, nrow1, ncol1);
      display(t);
      System.out.println();

      int nrow2 = in.nextInt();
      int ncol2 = in.nextInt();

      int[][] B = new int[nrow2][ncol2];
      for (int i = 0; i < nrow2; i++) {
        for (int j = 0; j < ncol2; j++) {
          B[i][j] = in.nextInt();
        }
      }

      display(B);
      System.out.println();
      t = transpose(B, nrow2, ncol2);
      display(t);
      System.out.println();

      int[][] C = new int[nrow1][ncol2];
      multiply(A, nrow1, ncol1, B, ncol2, C);
      display(C);
      System.out.println();

      t = transpose(C, nrow1, ncol2);
      display(t);
    }
  }

  private static void multiply(int[][] A, int nrow1, int ncol1, int[][] B,
                               int ncol2, int[][] C) {
    for (int i = 0; i < nrow1; i++) {
      for (int j = 0; j < ncol2; j++) {
        int s = 0;
        for (int k = 0; k < ncol1; k++) {
          s += A[i][k] * B[k][j];
        }

        C[i][j] = s;
      }
    }
  }

  private static void display(int[][] m) {
    for (int[] row : m) {
      for (int col : row) {
        System.out.printf("%d ", col);
      }
      System.out.println();
    }
  }

  private static int[][] transpose(int[][] m, int nrow, int ncol) {
    int[][] t = new int[ncol][nrow];

    for (int i = 0; i < nrow; i++) {
      for (int j = 0; j < ncol; j++) {
        t[j][i] = m[i][j];
      }
    }

    return t;
  }
}