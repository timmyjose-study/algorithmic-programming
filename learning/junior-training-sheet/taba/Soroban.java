import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Soroban {
  private static final Map<Integer, String> m;

  static {
    m = new HashMap<>();
    m.put(0, "O-|-OOOO");
    m.put(1, "O-|O-OOO");
    m.put(2, "O-|OO-OO");
    m.put(3, "O-|OOO-O");
    m.put(4, "O-|OOOO-");
    m.put(5, "-O|-OOOO");
    m.put(6, "-O|O-OOO");
    m.put(7, "-O|OO-OO");
    m.put(8, "-O|OOO-O");
    m.put(9, "-O|OOOO-");
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      do {
        System.out.println(m.get(n % 10));
        n /= 10;
      } while (n != 0);
    }
  }
}