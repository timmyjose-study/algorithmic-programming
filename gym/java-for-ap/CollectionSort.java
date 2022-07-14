import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CollectionSort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      List<String> l = new ArrayList<>();
      for (int i  = 0; i < n; i++) {
        l.add(in.nextLine());
      }

      Collections.sort(l);
      System.out.println(l);

      Collections.sort(l, Collections.reverseOrder());
      System.out.println(l);
    }
  }
}