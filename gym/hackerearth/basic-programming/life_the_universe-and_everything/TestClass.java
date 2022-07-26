import java.util.*;

class TestClass {
  public static void main(String args[]) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      while (true) {
        int n = in.nextInt();
        if (n != 42) {
          System.out.println(n);
        } else {
          break;
        }
      }
    }
  }
}