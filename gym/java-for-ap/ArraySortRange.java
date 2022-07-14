import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArraySortRange {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int f = in.nextInt();
      int t = in.nextInt();

      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }

      Arrays.sort(a, f, t);
      System.out.println(Arrays.toString(a));
    }
  }
}



