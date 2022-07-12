import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Cypher {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
          w[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
          int m = in.nextInt();
          char[] ms = in.nextLine().strip().toCharArray();
          for (int j = 0; j < m; j++) {
            if (ms[j] == 'U') {
              w[i] = (w[i] - 1) % 10;
              if (w[i] < 0) {
                w[i] = 9;
              }
            } else {
              w[i] = (w[i] + 1) % 10;
            }
          }
        }

        for (int i = 0; i < n; i++) {
          if (i > 0) {
            System.out.printf(" ");
          }
          System.out.printf("%d", w[i]);
        }
        System.out.println();
      }
    }
  }
}