import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NaturalOrdering {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      String a[] = new String[n];

      for (int i = 0; i < n; i++) {
        a[i] = in.nextLine();
      }

      // natural ordering for StringS is lexicographical ordering
      Arrays.sort(a);
      System.out.println(Arrays.toString(a));
    }
  }
}



