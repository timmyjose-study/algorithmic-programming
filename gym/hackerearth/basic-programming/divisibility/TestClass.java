import java.util.*;

class TestClass {
  public static void main(String args[]) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      for (int i = 0; i < n - 1; i++) {
        in.nextInt();
      }

      int digit = in.nextInt() % 10;
      if (digit == 0) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}