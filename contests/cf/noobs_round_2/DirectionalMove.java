// TLE
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DirectionalMove {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();
        int dir = 0;
        char[] a = in.nextLine().trim().toCharArray();
        for (char c : a) {
          switch (c) {
          case '0':
            dir = (dir + 1) % 4;
            break;
          case '1':
            dir = (dir + 3) % 4;
            break;
          }
        }

        switch (dir) {
        case 0:
          System.out.println("E");
          break;
        case 1:
          System.out.println("S");
          break;
        case 2:
          System.out.println("W");
          break;
        case 3:
          System.out.println("N");
        }
      }
    }
  }
}