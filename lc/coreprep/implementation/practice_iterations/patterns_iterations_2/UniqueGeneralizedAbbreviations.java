import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class UniqueGeneralizedAbbreviations {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        var res = uniqueGeneralizedAbbreviations(s);
        for (var r : res) {
          System.out.println(r);
        }
      }
    }
  }

  private static String processString(String sub, String s) {
    StringBuilder sb = new StringBuilder();
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (j < sub.length() && (s.charAt(i) == sub.charAt(j))) {
        sb.append(sub.charAt(j));
        j++;
      } else {
        sb.append("1");
      }
    }

    StringBuilder res = new StringBuilder();
    int i = 0;
    int compressed = 0;
    while (i < sb.length()) {
      if (sb.charAt(i) == '1') {
        compressed++;
      } else {
        if (compressed != 0) {
          res.append(compressed);
          compressed = 0;
        }
        res.append(sb.charAt(i));
      }
      i++;
    }

    if (compressed != 0) {
      res.append(compressed);
    }

    return res.toString();
  }

  private static List<String> process(List<String> substrings, String s) {
    List<String> res = new ArrayList<>();
    for (String sub : substrings) {
      res.add(processString(sub, s));
    }

    return res;
  }

  private static List<String> substrings(String s) {
    List<String> res = new ArrayList<>();
    res.add("");

    for (char c : s.toCharArray()) {
      int size = res.size();

      for (int i = 0; i < size; i++) {
        String prev = res.get(i);
        String curr = prev + c;
        res.add(curr);
      }
    }

    return res;
  }

  // O(n x 2n) / O(n x 2n)
  public static List<String> uniqueGeneralizedAbbreviations(String s) {
    return process(substrings(s), s);
  }
}