import java.util.*;

public class Dijkstra {
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

  static class DistanceInfo {
    int distance;
    int lastVertex;

    DistanceInfo() {
      this.distance = Integer.MAX_VALUE;
      this.lastVertex = -1;
    }
  }

  @SuppressWarnings("unchecked")
  static class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Pair)) {
        return false;
      }

      Pair<T, U> other = (Pair<T, U>)o;
      return this.first.equals(other.first) && this.second.equals(other.second);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.first, this.second);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();
      int source = in.nextInt();
      Map<Pair<Integer, Integer>, Integer> weights = new HashMap<>();

      Graph g = new AdjacencySet(n);
      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int w = in.nextInt();

        g.addEdge(from, to);
        weights.put(new Pair<>(from, to), w);
      }

      dijkstra(g, source, weights);
    }
  }

  // O(|E|log|V|)
  private static void dijkstra(Graph g, int source,
                               Map<Pair<Integer, Integer>, Integer> weights) {
    Map<Integer, DistanceInfo> dist = new HashMap<>();
    for (int i = 0; i < g.size(); i++) {
      dist.put(i, new DistanceInfo());
    }

    dist.get(source).distance = 0;
    dist.get(source).lastVertex = source;

    PriorityQueue<Pair<Integer, Integer>> pq =
        new PriorityQueue<>((p, q) -> Integer.compare(p.second, q.second));
    pq.add(new Pair<>(source, 0));

    while (!pq.isEmpty()) {
      Pair<Integer, Integer> pair = pq.poll();
      int vertex = pair.first;
      int distance = pair.second;

      for (int neighbour : g.getAdjacentVertices(vertex)) {
        Pair<Integer, Integer> p = new Pair<>(vertex, neighbour);
        if (distance + weights.get(p) < dist.get(neighbour).distance) {
          dist.get(neighbour).distance = distance + weights.get(p);
          dist.get(neighbour).lastVertex = vertex;
          pq.add(new Pair<>(neighbour, dist.get(neighbour).distance));
        }
      }
    }

    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < g.size(); i++) {
      if (i == source) {
        continue;
      }

      int currVertex = i;
      int d = dist.get(currVertex).distance;

      if (d == -1) {
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