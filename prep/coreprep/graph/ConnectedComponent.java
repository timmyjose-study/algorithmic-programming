import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ConnectedComponent {
  static class Graph {
    static class Vertex {
      int v;
      Set<Integer> vs;

      Vertex(int v) {
        this.v = v;
        this.vs = new HashSet<>();
      }

      void addEdge(int v) { this.vs.add(v); }

      List<Integer> getAdjacentVertices() {
        List<Integer> neighbours = new ArrayList<>();
        for (int v : this.vs) {
          neighbours.add(v);
        }

        return neighbours;
      }
    }

    List<Vertex> vertices;
    int size;

    Graph(int size) {
      this.size = size;
      this.vertices = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        this.vertices.add(new Vertex(i));
      }
    }

    void addEdge(int v1, int v2) {
      if (v1 < 0 || v1 >= this.size || v2 < 0 || v2 >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.vertices.get(v1).addEdge(v2);
      this.vertices.get(v2).addEdge(v1);
    }

    List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      return this.vertices.get(v).getAdjacentVertices();
    }

    int size() { return this.size; }
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

      Map<Integer, Integer> cc = connectedComponents(g);

      int q = in.nextInt();
      for (int i = 0; i < q; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        if (cc.get(from).equals(cc.get(to))) {
          System.out.println("yes");
        } else {
          System.out.println("no");
        }
      }
    }
  }

  // O(|E| + |V|)
  private static Map<Integer, Integer> connectedComponents(Graph g) {
    Map<Integer, Integer> cc = new HashMap<>();
    int ccIndex = 0;
    boolean[] visited = new boolean[g.size()];

    for (int i = 0; i < g.size(); i++) {
      dfs(g, i, ccIndex, cc, visited);
      ccIndex++;
    }

    return cc;
  }

  private static void dfs(Graph g, int currVertex, int ccIndex,
                          Map<Integer, Integer> cc, boolean[] visited) {
    if (visited[currVertex]) {
      return;
    }

    Stack<Integer> st = new Stack<>();
    st.push(currVertex);

    while (!st.isEmpty()) {
      int vertex = st.pop();

      visited[vertex] = true;
      cc.put(vertex, ccIndex);

      for (int neighbour : g.getAdjacentVertices(vertex)) {
        if (!visited[neighbour]) {
          st.push(neighbour);
        }
      }
    }
  }
}