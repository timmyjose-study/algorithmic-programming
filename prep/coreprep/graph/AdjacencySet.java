import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencySet implements Graph {
  static class Node {
    int v;
    Set<Integer> neighbours;

    Node(int v) {
      this.v = v;
      this.neighbours = new HashSet<>();
    }

    void addAdjacentNeighbour(int v) { this.neighbours.add(v); }
    Set<Integer> getAdjacentNeighbours() { return this.neighbours; }
  }

  private int numVertices;
  private List<Node> vertices;
  private Graph.GraphType graphType;

  public AdjacencySet(int numVertices) {
    this(numVertices, Graph.GraphType.UNDIRECTED);
  }

  public AdjacencySet(int numVertices, Graph.GraphType graphType) {
    this.numVertices = numVertices;
    this.graphType = graphType;
    this.vertices = new ArrayList<>(numVertices);

    for (int i = 0; i < numVertices; i++) {
      this.vertices.add(new Node(i));
    }
  }

  @Override
  public void addEdge(int v1, int v2) {
    if (v1 < 0 || v1 >= this.numVertices || v2 < 0 || v2 >= this.numVertices) {
      throw new IllegalArgumentException("inavlid vertex");
    }

    this.vertices.get(v1).addAdjacentNeighbour(v2);
    if (this.graphType == Graph.GraphType.UNDIRECTED) {
      this.vertices.get(v2).addAdjacentNeighbour(v1);
    }
  }

  @Override
  public List<Integer> getAdjacentVertices(int v) {
    if (v < 0 || v >= this.numVertices) {
      throw new IllegalArgumentException("invalid vertex");
    }

    List<Integer> neighbours = new ArrayList<>();
    for (int vv : this.vertices.get(v).getAdjacentNeighbours()) {
      neighbours.add(vv);
    }

    neighbours.sort((x, y) -> Integer.compare(x, y));

    return neighbours;
  }

  @Override
  public int size() {
    return this.numVertices;
  }
}
