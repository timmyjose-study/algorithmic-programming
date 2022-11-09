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

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
          for (char c : word.toCharArray()) {
            if (!graph.containsKey(c)) {
              graph.put(c, new HashSet<>());
              indegree.put(c, 0);
            }
          }
        }

        for (int i = 0; i < words.length - 1; i++) {
          String curr = words[i];
          String next = words[i + 1];

          int len = Math.min(curr.length(), next.length());
          for (int j = 0; j < len; j++) {
            if (curr.charAt(j) != next.charAt(j)) {
              if (!graph.get(curr.charAt(j)).contains(next.charAt(j))) {
                graph.get(curr.charAt(j)).add(next.charAt(j));
                indegree.put(next.charAt(j), indegree.get(next.charAt(j)) + 1);
              }
              break;
            }
          }
        }

        System.out.println(findAlienAlphabet(graph, indegree));
      }
    }
  }

  // O(N + M) / O(N + M)
  public static String findAlienAlphabet(Map<Character, Set<Character>> graph,
                                         Map<Character, Integer> indegree) {
    Queue<Character> q = new ArrayDeque<>();

    for (var entry : indegree.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    StringBuilder res = new StringBuilder();
    while (!q.isEmpty()) {
      char v = q.poll();

      res.append(v);
      for (char neighbour : graph.get(v)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);
        if (indegree.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    if (res.length() != graph.size()) {
      throw new IllegalStateException("cycle detected");
    }

    return res.toString();
  }
}