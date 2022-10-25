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
    for (int i = 0; i < s.length(); i++) {
      freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (x, y) -> Integer.compare(y.getValue(), x.getValue()));

    for (var entry : freq.entrySet()) {
      maxHeap.add(entry);
    }

    StringBuilder res = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      var entry = maxHeap.poll();
      int f = entry.getValue();

      while (f-- > 0) {
        res.append(entry.getKey());
      }
    }

    return res.toString();
  }
}