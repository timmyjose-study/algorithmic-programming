import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Kosaraju {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    Graph transpose();
    int size();
  }

  static class AdjacencySet implements Graph {
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

    private List<Vertex> vertices;
    private int size;

    AdjacencySet(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex());
      }
    }

    @Override
    public void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertices");
      }

      this.vertices.get(from).addEdge(to);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    @Override
    public Graph transpose() {
      Graph trans = new AdjacencySet(size());

      for (int i = 0; i < size(); i++) {
        for (int v : getAdjacentVertices(i)) {
          trans.addEdge(v, i);
        }
      }

      return trans;
    }

    @Override
    public int size() {
      return this.size;
    }
  }

  // O(E + V) / O(E + V)
  public static List<List<Integer>> kosaraju(Graph g) {
    boolean[] visited = new boolean[g.size()];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfs1(g, i, visited, st);
      }
    }

    Graph trans = g.transpose();
    Arrays.fill(visited, false);

    List<List<Integer>> scc = new ArrayList<>();

    while (!st.isEmpty()) {
      int v = st.pop();
      List<Integer> comp = new ArrayList<>();
      dfs2(trans, v, visited, comp);

      if (!comp.isEmpty()) {
        scc.add(comp);
      }
    }

    return scc;
  }

  private static void dfs1(Graph g, int currVertex, boolean[] visited,
                           Stack<Integer> st) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      dfs1(g, neighbour, visited, st);
    }

    st.push(currVertex);
  }

  private static void dfs2(Graph g, int currVertex, boolean[] visited,
                           List<Integer> comp) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;
    comp.add(currVertex);

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      dfs2(g, neighbour, visited, comp);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g = new AdjacencySet(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
      }

      var scc = kosaraju(g);
      System.out.println(scc.size());
      for (var comp : scc) {
        for (int c : comp) {
          System.out.printf("%d ", c);
        }
        System.out.println();
      }
    }
  }
}