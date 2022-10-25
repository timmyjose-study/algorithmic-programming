import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class AlienDictionary {
  static interface Graph {
    Set<Character> allVertices();
    void addEdge(char from, char to);
    List<Character> getAdjacentVertices(char v);
    int indegree(char v);
    int size();
  }

  static class AdjacencySet implements Graph {
    static class Vertex {
      Set<Character> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(char v) { this.vs.add(v); }

      List<Character> getAdjacentVertices() { return new ArrayList<>(this.vs); }

      boolean hasEdge(char v) { return this.vs.contains(v); }
    }

    private Map<Character, Vertex> adjSet;

    AdjacencySet() { this.adjSet = new HashMap<>(); }

    @Override
    public void addEdge(char from, char to) {
      if (!adjSet.containsKey(from)) {
        this.adjSet.put(from, new Vertex());
      }

      if (!adjSet.containsKey(to)) {
        this.adjSet.put(to, new Vertex());
      }

      this.adjSet.get(from).addEdge(to);
    }

    @Override
    public List<Character> getAdjacentVertices(char v) {
      return this.adjSet.get(v).getAdjacentVertices();
    }

    @Override
    public int indegree(char v) {
      int indeg = 0;
      for (var entry : adjSet.entrySet()) {
        if (entry.getValue().hasEdge(v)) {
          indeg++;
        }
      }

      return indeg;
    }

    @Override
    public Set<Character> allVertices() {
      return this.adjSet.keySet();
    }

    @Override
    public int size() {
      return this.adjSet.size();
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();

      while (tt-- > 0) {
        int n = in.nextInt();
        in.nextLine();

        String[] dictionary = new String[n];
        for (int i = 0; i < n; i++) {
          dictionary[i] = in.nextLine().trim();
        }

        Graph g = processDictionary(dictionary);
        System.out.println(alienDictionaryOrdering(g));
      }
    }
  }

  private static Graph processDictionary(String[] dictionary) {
    Graph g = new AdjacencySet();

    for (int i = 0; i < dictionary.length - 1; i++) {
      for (int j = 0;
           j < Math.min(dictionary[i].length(), dictionary[i + 1].length());
           j++) {
        if (dictionary[i].charAt(j) != dictionary[i + 1].charAt(j)) {
          g.addEdge(dictionary[i].charAt(j), dictionary[i + 1].charAt(j));
          break;
        }
      }
    }

    return g;
  }

  // O(V + W) / O(V + W)
  public static String alienDictionaryOrdering(Graph g) {
    StringBuilder ordering = new StringBuilder();

    Queue<Character> q = new ArrayDeque<>();

    Map<Character, Integer> indegree = new HashMap<>();
    for (char v : g.allVertices()) {
      int d = g.indegree(v);
      indegree.put(v, d);

      if (d == 0) {
        q.add(v);
      }
    }

    while (!q.isEmpty()) {
      char v = q.poll();

      ordering.append(v);

      for (char neighbour : g.getAdjacentVertices(v)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);

        if (indegree.get(neighbour) == 0) {
          q.add(neighbour);
        }
      }
    }

    return ordering.toString();
  }
}