import java.util.Scanner;

public class StringHash {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String s = in.nextLine().trim();
        System.out.printf("stringHash(%s) = %d\n", s, stringHash(s));
      }
    }
  }

  private static long stringHash(String s) {
    int p = 53;
    int m = (int)1e9 + 9;
    long ppow = 1;

    long hash_val = 0;
    for (int i = 0; i < s.length(); i++) {
      hash_val = (hash_val + (s.charAt(i) - ' ' + 1) * ppow) % m;
      ppow = (ppow * p) % m;
    }

    if (hash_val < 0) {
      hash_val += m;
    }

    return hash_val;
  }
}