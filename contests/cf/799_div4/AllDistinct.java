// Unsolved
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AllDistinct {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      while (tt-- > 0) {
        int n = in.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
          int d = in.nextInt();
          if (!m.containsKey(d)) {
            m.put(d, 1);
          } else {
            m.put(d, m.get(d) + 1);
          }
        }

        int sol = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
          if (entry.getValue() % 2 == 1) {
            sol++;
          }
        }

        System.out.println(sol);
        m.clear();
      }
    }
  }
}