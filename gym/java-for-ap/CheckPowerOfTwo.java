import java.util.Scanner;

public class CheckPowerOfTwo {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      System.out.println(((n != 0) && (n & (n -1)) == 0) ? "Yes" : "No");
    }
  }
}

