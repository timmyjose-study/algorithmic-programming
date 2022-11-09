import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class RearrangeString {
  private static final char NULL = '\u0000';

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        System.out.println(rearrange(s));
      }
    }
  }

  // O(nlogn) / O(n)
  public static String rearrange(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : s.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (c1, c2) -> Integer.compare(freq.get(c2), freq.get(c1)));

    for (var entry : freq.entrySet()) {
      maxHeap.add(entry.getKey());
    }

    char prev = NULL;
    StringBuilder res = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      char curr = maxHeap.poll();

      res.append(curr);
      freq.put(curr, freq.get(curr) - 1);

      if (prev != NULL && freq.get(prev) > 0) {
        maxHeap.add(prev);
      }
      prev = curr;
    }

    return (res.length() == s.length()) ? res.toString() : "";
  }
}