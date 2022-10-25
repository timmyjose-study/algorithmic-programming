import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AlienDictionary {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
          words[i] = in.nextLine().trim();
        }

        Map<Character, Set<Character>> g = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
          for (char c : word.toCharArray()) {
            g.put(c, new HashSet<>());
            indegree.put(c, 0);
          }
        }

        for (int i = 0; i < n - 1; i++) {
          String curr = words[i];
          String next = words[i + 1];

          int len = Math.min(curr.length(), next.length());
          for (int j = 0; j < len; j++) {
            if (curr.charAt(j) != next.charAt(j)) {
              if (!g.get(curr.charAt(j)).contains(next.charAt(j))) {
                g.get(curr.charAt(j)).add(next.charAt(j));
                indegree.put(next.charAt(j), indegree.get(next.charAt(j)) + 1);
              }
              break;
            }
          }
        }

        String ordering = sort(g, indegree);
        System.out.println(ordering);
      }
    }
  }

  // O(L + W) / O(L + W)
  public static String sort(Map<Character, Set<Character>> g,
                            Map<Character, Integer> indegree) {
    Queue<Character> q = new ArrayDeque<>();

    for (char c : g.keySet()) {
      if (indegree.get(c) == 0) {
        q.add(c);
      }
    }

    StringBuilder ordering = new StringBuilder();
    while (!q.isEmpty()) {
      char v = q.poll();

      ordering.append(v);

      for (char neighbour : g.get(v)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);
        if (indegree.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    if (ordering.length() != g.size()) {
      throw new IllegalStateException("cycle detected");
    }

    return ordering.toString();
  }
}