import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class HouseThiefBrute {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();

        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) {
          amounts[i] = in.nextInt();
        }

        System.out.println(maxAmount(amounts));
      }
    }
  }

  // O(2n) / O(n)
  public static int maxAmount(int[] amounts) { return maxAmount(amounts, 0); }

  private static int maxAmount(int[] amounts, int currIdx) {
    if (currIdx >= amounts.length) {
      return 0;
    }

    int choose = amounts[currIdx] + maxAmount(amounts, currIdx + 2);
    int notChoose = maxAmount(amounts, currIdx + 1);

    return Math.max(choose, notChoose);
  }
}