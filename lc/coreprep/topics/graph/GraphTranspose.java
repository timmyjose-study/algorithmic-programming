import java.util.*;

public class GraphTranspose {
  static interface Graph {
    void addEdge(int from, int to);
    List<Integer> getAdjacentVertices(int v);
    int size();
    void display();
    Graph transpose();
  }

  static class AdjacencySet implements Graph {
    static class Vertex {
      Set<Integer> vs;

      Vertex() { this.vs = new HashSet<>(); }

      void addEdge(int v) { this.vs.add(v); }

      List<Integer> getAdjacentVertices() {
        List<Integer> neighbours = new ArrayList<>();

        for (int v : this.vs) {
          neighbours.add(v);
        }
        neighbours.sort((v1, v2) -> Integer.compare(v1, v2));

        return neighbours;
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

    // O(|V| + |E|)
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

    @Override
    public void display() {
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d: ", i);

        for (int v : getAdjacentVertices(i)) {
          System.out.printf("%d ", v);
        }
        System.out.println();
      }
    }
  }

  static class AdjacencyMatrix implements Graph {
    private int size;
    private int[][] adj;

    AdjacencyMatrix(int size) {
      this.size = size;
      this.adj = new int[size][size];
    }

    @Override
    public void addEdge(int from, int to) {
      if (from < 0 || from >= this.size || to < 0 || to >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      this.adj[from][to] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
      if (v < 0 || v >= this.size) {
        throw new IllegalArgumentException("invalid vertex");
      }

      List<Integer> neighbours = new ArrayList<>();

      for (int i = 0; i < this.size; i++) {
        if (adj[v][i] == 1) {
          neighbours.add(i);
        }
      }
      neighbours.sort((v1, v2) -> Integer.compare(v1, v2));

      return neighbours;
    }

    @Override
    public int size() {
      return this.size;
    }

    // O(|V| + |E|)
    @Override
    public Graph transpose() {
      Graph trans = new AdjacencyMatrix(this.size);

      for (int i = 0; i < this.size; i++) {
        for (int j = 0; j < this.size; j++) {
          if (this.adj[i][j] == 1) {
            trans.addEdge(j, i);
          }
        }
      }

      return trans;
    }

    @Override
    public void display() {
      for (int i = 0; i < this.size; i++) {
        for (int j = 0; j < this.size; j++) {
          System.out.printf("%d ", this.adj[i][j]);
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Graph g1 = new AdjacencySet(n);
      Graph g2 = new AdjacencyMatrix(n);

      int m = in.nextInt();
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();

        g1.addEdge(from, to);
        g2.addEdge(from, to);
      }

      Graph g1t = g1.transpose();
      g1.display();
      g1t.display();

      Graph g2t = g2.transpose();
      g2.display();
      g2t.display();
    }
  }
}