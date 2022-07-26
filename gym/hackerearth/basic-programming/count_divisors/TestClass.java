import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class TestClass {
  public static void main(String args[]) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int l = in.nextInt();
      int r = in.nextInt();
      int k = in.nextInt();

      int c = 0;
      for (int i = l; i <= r; i++) {
        if (i % k == 0) {
          c++;
        }
      }

      System.out.println(c);
    }
  }
}