import java.util.*;

public class TestClass {
  static class Graph {
    static class Vertex {
      Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(int v) { this.vs.add(v); }
      List<Integer> getAdjacentVertices() {
        List<Integer> ns = new ArrayList<>();

        for (int v : this.vs) {
          ns.add(v);
        }

        return ns;
      }
    }
    private int size;
    private List<Vertex> vertices;
    private List<Vertex> revVertices;

    Graph(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);
      this.revVertices = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
        this.revVertices.add(new Vertex());
      }
    }

    int size() { return this.size; }

    void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.vertices.get(from).addEdge(to);
      this.revVertices.get(to).addEdge(from);
    }

    List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    List<Integer> getRevAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.revVertices.get(v).getAdjacentVertices();
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new Graph(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from - 1, to - 1);
      }

      kosaraju(g);
    }
  }

  private static void kosaraju(Graph g) {
    Stack<Integer> st = new Stack<>();
    boolean[] visited = new boolean[g.size()];

    for (int i = 0; i < g.size(); i++) {
      dfs1(g, visited, i, st);
    }

    visited = new boolean[g.size()];

    int oddSum = 0, evenSum = 0;
    while (!st.empty()) {
      int v = st.pop();
      List<Integer> comp = new ArrayList<>();

      dfs2(g, visited, v, comp);

      if (!comp.isEmpty()) {
        if (comp.size() % 2 == 0) {
          evenSum += comp.size();
        } else {
          oddSum += comp.size();
        }
      }
    }

    System.out.printf("%d\n", oddSum - evenSum);
  }

  private static void dfs1(Graph g, boolean[] visited, int currVertex,
                           Stack<Integer> st) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs1(g, visited, neighbour, st);
      }
    }

    st.push(currVertex);
  }

  private static void dfs2(Graph g, boolean[] visited, int currVertex,
                           List<Integer> comp) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;
    comp.add(currVertex);

    for (int neighbour : g.getRevAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs2(g, visited, neighbour, comp);
      }
    }
  }
}