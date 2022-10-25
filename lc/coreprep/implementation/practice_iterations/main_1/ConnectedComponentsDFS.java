import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ConnectedComponentsDFS {
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
    public int size() {
      return this.size;
    }
  }

  // O(E + V) / O(E + V)
  public static void dfs(Graph g, Map<Integer, Integer> compMap) {
    boolean[] visited = new boolean[g.size()];
    int compId = 0;

    for (int i = 0; i < g.size(); i++) {
      if (!visited[i]) {
        dfs(g, visited, i, compId, compMap);
      }
      compId++;
    }
  }

  private static void dfs(Graph g, boolean[] visited, int currVertex,
                          int compId, Map<Integer, Integer> compMap) {
    Stack<Integer> st = new Stack<>();
    st.push(currVertex);

    while (!st.isEmpty()) {
      int v = st.pop();

      if (visited[v]) {
        continue;
      }

      visited[v] = true;
      compMap.put(v, compId);

      for (int neighbour : g.getAdjacentVertices(v)) {
        st.push(neighbour);
      }
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
        g.addEdge(to, from);
      }

      Map<Integer, Integer> compMap = new HashMap<>();
      dfs(g, compMap);

      int nq = in.nextInt();
      while (nq-- > 0) {
        int from = in.nextInt();
        int to = in.nextInt();

        if (compMap.get(from) == compMap.get(to)) {
          System.out.println("yes");
        } else {
          System.out.println("no");
        }
      }
    }
  }
}