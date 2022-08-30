import java.util.*;

public class RabinKarp {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String needle = in.nextLine().trim();
        String haystack = in.nextLine().trim();

        List<Integer> positions = rabinKarp(needle, haystack);
        if (positions.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(positions.size());
          for (int pos : positions) {
            System.out.printf("%d ", pos);
          }
          System.out.println();
        }
      }
    }
  }
}