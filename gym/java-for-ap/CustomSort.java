import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomSort { 
  public static void main(String[] args) {
    try(Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Person a[] = new Person[n];

      for (int i = 0; i < n; i++) {
        int id = in.nextInt();
        String name = in.next();
        String location = in.next();
        a[i] = new Person(id, name, location);
      }

      // Arrays.sort works on primitives, Collections.sort does not
      Arrays.sort(a, (p1, p2)->p1.id() - p2.id());
      System.out.println(Arrays.toString(a));
    }
  }
}

record
Person(int id, String name, String location) {
}