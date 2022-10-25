import java.util.*;

public class AdjacencySetDFS {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
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

      for (int i = 0; i < this.size; i++) {
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
  }

  public static void dfsPre(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfsPre(g, visited, i);
      }
    }
    System.out.println();
  }

  private static void dfsPre(Graph g, boolean[] visited, int currVertex) {
    visited[currVertex] = true;
    System.out.printf("%s ", currVertex);

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfsPre(g, visited, neighbour);
      }
    }
  }

  public static void dfsPreIter(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfsPreIter(g, visited, i);
      }
    }
    System.out.println();
  }

  private static void dfsPreIter(Graph g, boolean[] visited, int currVertex) {
    Stack<Integer> st = new Stack<>();
    st.push(currVertex);

    while (!st.isEmpty()) {
      int v = st.pop();

      visited[v] = true;
      System.out.printf("%s ", v);

      for (int neighbour : g.getAdjacentVertices(v)) {
        if (!visited[neighbour]) {
          st.push(neighbour);
        }
      }
    }
  }

  public static void dfsPost(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfsPost(g, visited, i);
      }
    }
    System.out.println();
  }

  private static void dfsPost(Graph g, boolean[] visited, int currVertex) {
    visited[currVertex] = true;

    for (int neighbour : g.getAdjacentVertices(currVertex)) {
      if (!visited[neighbour]) {
        dfsPost(g, visited, neighbour);
      }
    }

    System.out.printf("%s ", currVertex);
  }

  public static void dfsPostIter(Graph g) {
    boolean[] visited = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfsPostIter(g, visited, i);
      }
    }
    System.out.println();
  }

  private static void dfsPostIter(Graph g, boolean[] visited, int currVertex) {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> revSt = new Stack<>();

    st.push(currVertex);
    while (!st.isEmpty()) {
      int v = st.pop();

      visited[v] = true;
      revSt.push(v);

      for (int neighbour : g.getAdjacentVertices(v)) {
        if (!visited[neighbour]) {
          st.push(neighbour);
        }
      }
    }

    while (!revSt.isEmpty()) {
      System.out.printf("%s ", revSt.pop());
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();

      Graph g = new AdjacencySet(n);
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g.addEdge(from, to);
        g.addEdge(to, from);
      }

      dfsPre(g);
      dfsPreIter(g);

      dfsPost(g);
      dfsPostIter(g);
    }
  }
}