import java.util.*;

public class Kosaraju {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    int size();
    Graph transpose();
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

        ns.sort((v1, v2) -> Integer.compare(v1, v2));
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
        throw new IllegalArgumentException("invalid vertex");
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
    public int size() {
      return this.size;
    }

    @Override
    public Graph transpose() {
      Graph trans = new AdjacencySet(this.size);

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
      Graph g = new AdjacencySet(n);

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
    boolean[] visited = new boolean[g.size()];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < g.size(); i++) {
      dfs1(g, visited, st, i);
    }

    Arrays.fill(visited, false);
    Graph trans = g.transpose();

    List<List<Integer>> scc = new ArrayList<>();
    while (!st.empty()) {
      int v = st.pop();
      List<Integer> comp = new ArrayList<>();
      dfs2(trans, visited, v, comp);

      if (!comp.isEmpty()) {
        scc.add(comp);
      }
    }

    System.out.println(scc.size());
    for (List<Integer> comp : scc) {
      for (int c : comp) {
        System.out.printf("%d ", c);
      }
      System.out.println();
    }
  }

  private static void dfs1(Graph g, boolean[] visited, Stack<Integer> st,
                           int currVertex) {
    if (visited[currVertex]) {
      return;
    }

    visited[currVertex] = true;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs1(g, visited, st, neighbour);
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

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfs2(g, visited, neighbour, comp);
      }
    }
  }
}