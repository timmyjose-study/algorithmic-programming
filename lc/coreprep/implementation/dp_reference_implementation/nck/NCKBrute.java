import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class NCKBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(nck(n, k));
      }
    }
  }

  // O(nck) / O(nck)
  public static long nck(int n, int k) {
    if (k == 0 || k == n) {
      return 1;
    }

    return nck(n - 1, k - 1) + nck(n - 1, k);
  }
}