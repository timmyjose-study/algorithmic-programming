import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MakeAllOdd {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        int[] a = new int[n];
        int ec = 0, oc = 0;

        for (int i = 0; i < n; i++) {
          a[i] = in.nextInt();
          if (a[i] % 2 == 0) {
            ec++;
          } else {
            oc++;
          }
        }

        if (oc == 0) {
          System.out.println(-1);
        } else {
          System.out.println(ec);
        }
      }
    }
  }
}