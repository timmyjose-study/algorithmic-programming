import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

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

  static class Entry {
    String s;
    int nl;
    int nr;

    Entry(String s, int nl, int nr) {
      this.s = s;
      this.nl = nl;
      this.nr = nr;
    }
  }

  // O(n x 2n) / O(n x 2n)
  public static List<String> balanceParentheses(int n) {
    Queue<Entry> q = new ArrayDeque<>();
    q.add(new Entry("(", 1, 0));

    List<String> res = new ArrayList<>();
    while (!q.isEmpty()) {
      int size = q.size();

      int addedThisRound = 0;
      for (int i = 0; i < size; i++) {
        Entry prev = q.poll();

        if (prev.nl < n) {
          Entry leftEntry = new Entry(prev.s + "(", prev.nl + 1, prev.nr);
          q.add(leftEntry);
          addedThisRound++;
        }

        if (prev.nr < prev.nl) {
          Entry rightEntry = new Entry(prev.s + ")", prev.nl, prev.nr + 1);
          q.add(rightEntry);
          addedThisRound++;
        }

        if (addedThisRound == 0) {
          res.add(prev.s);
        }
      }
    }

    return res;
  }
}