import java.util.Scanner;

public class FastMultiplication {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      System.out.printf("%d * 2 = %d, %d / 2 = %d\n", n, n << 1, n, n >> 1);
    }
  }
}

