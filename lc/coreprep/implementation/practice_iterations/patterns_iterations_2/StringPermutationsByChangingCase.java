import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class StringPermutationsByChangingCase {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        var res = permutations(s);
        for (var r : res) {
          System.out.println(r);
        }
      }
    }
  }

  // O(n x 2n) / O(n x 2n)
  public static List<String> permutations(String s) {
    List<String> res = new ArrayList<>();

    Queue<String> q = new ArrayDeque<>();
    q.add("");

    for (char c : s.toCharArray()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        String prev = q.poll();

        if (Character.isDigit(c)) {
          prev += c;
          q.add(prev);
        } else {
          String curr1 = prev + Character.toLowerCase(c);
          String curr2 = prev + Character.toUpperCase(c);
          q.add(curr1);
          q.add(curr2);
        }
      }
    }

    while (!q.isEmpty()) {
      res.add(q.poll());
    }

    return res;
  }
}