import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n * 2^n) / O(n * 2^n)
public class StringPermutationsByChangingCase {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();

        var res = permute(s);
        for (String p : res) {
          System.out.println(p);
        }
      }
    }
  }

  private static List<String> permute(String s) {
    List<String> allPerms = new ArrayList<>();

    if (s == null || s.isEmpty()) {
      return allPerms;
    }

    allPerms.add(s);

    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i))) {
        int n = allPerms.size();

        for (int j = 0; j < n; j++) {
          char[] a = allPerms.get(j).toCharArray();

          if (Character.isLowerCase(a[i])) {
            a[i] = Character.toUpperCase(a[i]);
          } else {
            a[i] = Character.toLowerCase(a[i]);
          }

          allPerms.add(String.valueOf(a));
        }
      }
    }

    return allPerms;
  }
}