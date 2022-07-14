import java.util.Scanner;

public class EvenOrOdd {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      System.out.println(((n & 1) == 0) ? "Even" : "Odd");
    }
  }
}

