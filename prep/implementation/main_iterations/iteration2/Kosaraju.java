import java.util.*;

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

        ns.sort(Integer::compare);
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

  public static void kosaraju(Graph g) {
    boolean[] visited = new boolean[g.size()];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < g.size(); i++) {
      dfs1(g, visited, i, st);
    }

    Graph trans = g.transpose();
    List<List<Integer>> scc = new ArrayList<>();

    Arrays.fill(visited, false);

    while (!st.isEmpty()) {
      int v = st.pop();

      List<Integer> comp = new ArrayList<>();
      dfs2(trans, visited, v, comp);

      if (!comp.isEmpty()) {
        scc.add(comp);
      }
    }

    int sccCount = scc.size();
    if (sccCount == 0) {
      System.out.println("no SCC");
    } else {
      System.out.println(sccCount);

      for (List<Integer> comp : scc) {
        for (int c : comp) {
          System.out.printf("%d ", c);
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
      dfs1(g, visited, neighbour, st);
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
      dfs2(g, visited, neighbour, comp);
    }
  }
}