import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class StaircaseBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        System.out.println(numWays(n));
      }
    }
  }

  // O(3n) / O(n)
  public static int numWays(int n) {
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    return numWays(n - 1) + numWays(n - 2) + numWays(n - 3);
  }
}