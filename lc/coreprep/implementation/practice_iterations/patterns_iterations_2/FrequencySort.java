import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FrequencySort {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
        String s = in.nextLine().trim();
        System.out.println(sort(s));
      }
    }
  }

  // O(nlogn) / O(n)
  public static String sort(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : s.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (c1, c2) -> Integer.compare(freq.get(c2), freq.get(c1)));

    for (var entry : freq.entrySet()) {
      maxHeap.add(entry.getKey());
    }

    StringBuilder res = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      char c = maxHeap.poll();
      int f = freq.get(c);

      for (int i = 0; i < f; i++) {
        res.append(c);
      }
    }

    return res.toString();
  }
}