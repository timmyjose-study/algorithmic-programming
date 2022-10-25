import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n x 2^n) / O(n x 2^n)
public class BalancedParentheses {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        var res = balanceParentheses(n);
        for (var r : res) {
          System.out.println(r);
        }
      }
    }
  }

  static class ParenString {
    String s;
    int open;
    int close;

    ParenString(String s, int open, int close) {
      this.s = s;
      this.open = open;
      this.close = close;
    }
  }

  private static List<String> balanceParentheses(int n) {
    List<String> res = new ArrayList<>();

    Queue<ParenString> q = new ArrayDeque<>();
    q.add(new ParenString("", 0, 0));

    while (!q.isEmpty()) {
      ParenString ps = q.poll();

      if (ps.open == n && ps.close == n) {
        res.add(ps.s);
      } else {
        if (ps.open < n) {
          q.add(new ParenString(ps.s + "(", ps.open + 1, ps.close));
        }

        if (ps.open > ps.close) {
          q.add(new ParenString(ps.s + ")", ps.open, ps.close + 1));
        }
      }
    }

    return res;
  }
}