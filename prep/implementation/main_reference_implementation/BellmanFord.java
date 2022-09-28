import java.util.*;

public class BellmanFord {
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

  static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.first, this.second);
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Pair)) {
        return false;
      }

      Pair other = (Pair)o;
      return this.first == other.first && this.second == other.second ||
          this.first == other.second && this.second == other.first;
    }
  }

  static class DistanceInfo {
    int distance;
    int lastVertex;

    DistanceInfo() {
      this.distance = Integer.MAX_VALUE;
      this.lastVertex = -1;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();
      int source = in.nextInt();
      Map<Pair, Integer> weights = new HashMap<>();

      Graph g = new AdjacencySet(n);
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int w = in.nextInt();

        g.addEdge(from, to);
        weights.put(new Pair(from, to), w);
      }

      bellmanFord(g, source, weights);
    }
  }

  // O(|E| * |V|)
  private static void bellmanFord(Graph g, int source,
                                  Map<Pair, Integer> weights) {
    Map<Integer, DistanceInfo> dist = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      dist.put(i, new DistanceInfo());
    }

    dist.get(source).distance = 0;
    dist.get(source).lastVertex = source;

    Queue<Integer> q = new ArrayDeque<>();
    Set<Pair> visited = new HashSet<>();

    for (int i = 0; i < g.size() - 1; i++) {
      for (int j = 0; j < g.size(); j++) {
        q.add(j);
      }

      while (!q.isEmpty()) {
        int from = q.poll();

        for (int neighbour : g.getAdjacentVertices(from)) {
          Pair edge = new Pair(from, neighbour);

          if (visited.contains(edge)) {
            continue;
          }

          visited.add(edge);

          if (dist.get(from).distance + weights.get(edge) <
              dist.get(neighbour).distance) {
            dist.get(neighbour).distance =
                dist.get(from).distance + weights.get(edge);
            dist.get(neighbour).lastVertex = from;
          }
        }
      }

      q.clear();
      visited.clear();
    }

    for (int i = 0; i < g.size(); i++) {
      q.add(i);
    }

    while (!q.isEmpty()) {
      int from = q.poll();

      for (int neighbour : g.getAdjacentVertices(from)) {
        Pair edge = new Pair(from, neighbour);

        if (visited.contains(edge)) {
          continue;
        }

        visited.add(edge);
        if (dist.get(from).distance + weights.get(edge) <
            dist.get(neighbour).distance) {
          throw new IllegalStateException("negative weight cycle detected");
        }
      }
    }

    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < g.size(); i++) {
      if (i == source) {
        continue;
      }

      int currVertex = i;
      int d = dist.get(i).distance;
      if (d == Integer.MAX_VALUE) {
        System.out.println("no path");
      } else {
        System.out.println(d);
        while (currVertex != -1 && currVertex != source) {
          st.push(currVertex);
          currVertex = dist.get(currVertex).lastVertex;
        }
        st.push(source);

        while (!st.empty()) {
          System.out.printf("%d ", st.pop());
        }
        System.out.println();
      }
    }
  }
}