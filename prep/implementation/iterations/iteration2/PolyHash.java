import java.util.*;

public class PolyHash {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String s = in.nextLine().trim();
        System.out.println(polyHash(s));
      }
    }
  }
}