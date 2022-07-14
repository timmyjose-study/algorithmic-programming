import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class NumberConversions {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      System.out.printf("Decimal = %s, Binary = %s, Octal = %s, Hexadecimal = %s\n",
          Integer.toString(n),
          Integer.toString(n, 2),
          Integer.toString(n, 8),
          Integer.toString(n, 16));
    }
  }
}

