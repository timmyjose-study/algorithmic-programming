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

  @SuppressWarnings("unchecked")
  static class Pair<T extends Comparable<T>, U extends Comparable<U>> {
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
      return this.first.compareTo(other.first) == 0 &&
          this.second.compareTo(other.second) == 0;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.first, this.second);
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
  public static void
  dijkstra(Graph g, Map<Pair<Integer, Integer>, Integer> weights, int source) {
    DistanceInfo[] dist = new DistanceInfo[g.size()];
    for (int i = 0; i < g.size(); i++) {
      dist[i] = new DistanceInfo();
    }

    dist[source].distance = 0;
    dist[source].lastVertex = source;

    PriorityQueue<Pair<Integer, Integer>> pq =
        new PriorityQueue<>((p, q) -> Integer.compare(p.second, q.second));
    pq.add(new Pair<>(source, 0));

    while (!pq.isEmpty()) {
      Pair<Integer, Integer> p = pq.poll();
      int from = p.first;
      int d = p.second;

      for (int neighbour : g.getAdjacentVertices(from)) {
        Pair<Integer, Integer> edge = new Pair<>(from, neighbour);

        if (weights.get(edge) + dist[from].distance <
            dist[neighbour].distance) {
          dist[neighbour].distance = weights.get(edge) + dist[from].distance;
          dist[neighbour].lastVertex = from;
          pq.add(new Pair<>(neighbour, dist[neighbour].distance));
        }
      }
    }

    for (int i = 0; i < g.size(); i++) {
      if (i == source) {
        continue;
      }

      int d = dist[i].distance;
      if (d == Integer.MAX_VALUE) {
        System.out.println("no path");
      } else {
        System.out.println(d);

        Stack<Integer> st = new Stack<>();
        int currVertex = i;

        while (currVertex != source) {
          st.push(currVertex);
          currVertex = dist[currVertex].lastVertex;
        }
        st.push(source);

        while (!st.isEmpty()) {
          System.out.printf("%d ", st.pop());
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int m = in.nextInt();
      int source = in.nextInt();

      Graph g = new AdjacencySet(n);
      Map<Pair<Integer, Integer>, Integer> weights = new HashMap<>();

      for (int i = 0; i < m; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        int w = in.nextInt();

        g.addEdge(from, to);
        weights.put(new Pair<>(from, to), w);
      }

      dijkstra(g, weights, source);
    }
  }
}