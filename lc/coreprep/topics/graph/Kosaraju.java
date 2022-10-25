import java.util.*;

public class Kosaraju {
  static class Graph {
    static class Vertex {
      Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }
      void addEdge(int v) { this.vs.add(v); }
      List<Integer> getAdjacentVertices() {
        List<Integer> neighbours = new ArrayList<>();

        for (int v : this.vs) {
          neighbours.add(v);
        }

        return neighbours;
      }
    }

    private int size;
    private List<Vertex> vertices;

    Graph(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
      }
    }

    void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.vertices.get(from).addEdge(to);
    }

    List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    int size() { return this.size; }

    Graph transpose() {
      Graph trans = new Graph(this.size);

      for (int i = 0; i < this.size; i++) {
        for (int v : getAdjacentVertices(i)) {
          trans.addEdge(v, i);
        }
      }

      return trans;
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
        g.addEdge(from, to);
      }

      kosaraju(g);
    }
  }

  // O(|V| + |E|)
  private static void kosaraju(Graph g) {
    Stack<Integer> st = new Stack<>();
    boolean[] visited = new boolean[g.size];

    for (int i = 0; i < g.size(); i++) {
      dfs1(g, visited, 0, st);
    }

    Graph trans = g.transpose();
    List<List<Integer>> scc = new ArrayList<>();

    visited = new boolean[g.size()];
    while (!st.empty()) {
      int v = st.pop();
      List<Integer> comp = new ArrayList<>();

      dfs2(trans, visited, v, comp);

      if (!comp.isEmpty()) {
        scc.add(comp);
      }
    }

    System.out.println(scc.size());
    if (!scc.isEmpty()) {
      for (List<Integer> comp : scc) {
        for (int v : comp) {
          System.out.printf("%d ", v);
        }
        System.out.println();
      }
    }
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
                           List<Integer> scc) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;
    scc.add(currVertex);

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs2(g, visited, neighbour, scc);
      }
    }
  }
}