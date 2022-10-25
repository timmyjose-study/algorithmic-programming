import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

// O(n x 2^n) / O(n x 2^n)
public class UniqueGeneralizedAbbreviations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        var res = abbreviate(s);
        for (var r : res) {
          System.out.println(r);
        }
      }
    }
  }

  static class Abbreviation {
    String s;
    int pos;
    int count;

    Abbreviation(String s, int pos, int count) {
      this.s = s;
      this.pos = pos;
      this.count = count;
    }

    @Override
    public String toString() {
      return "<" + this.s + ", " + this.pos + ">";
    }
  }

  private static List<String> abbreviate(String s) {
    List<String> res = new ArrayList<>();

    Queue<Abbreviation> q = new ArrayDeque<>();
    q.add(new Abbreviation("", 0, 0));

    while (!q.isEmpty()) {
      Abbreviation abbr = q.poll();

      if (abbr.pos == s.length()) {
        if (abbr.count != 0) {
          abbr.s = abbr.s + abbr.count;
        }
        res.add(abbr.s);
      } else {
        q.add(new Abbreviation(abbr.s, abbr.pos + 1, abbr.count + 1));

        if (abbr.count != 0) {
          abbr.s = abbr.s + abbr.count;
        }
        q.add(new Abbreviation(abbr.s + s.charAt(abbr.pos), abbr.pos + 1, 0));
      }
    }

    return res;
  }
}