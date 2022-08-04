import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencySet implements Graph {
  static class Vertex {
    int v;
    Set<Integer> vertices;

    Vertex(int v) {
      this.v = v;
      this.vertices = new HashSet<>();
    }

    void addEdge(int v) { this.vertices.add(v); }
    Set<Integer> getAdjacentVertices() { return this.vertices; }
    boolean hasEdge(int v) { return this.vertices.contains(v); }
  }

  private int numVertices;
  private List<Vertex> adj;
  private Graph.GraphType graphType;

  public AdjacencySet(int numVertices) {
    this(numVertices, Graph.GraphType.UNDIRECTED);
  }

  public AdjacencySet(int numVertices, Graph.GraphType graphType) {
    this.numVertices = numVertices;
    this.graphType = graphType;
    this.adj = new ArrayList<>(numVertices);

    for (int i = 0; i < numVertices; i++) {
      this.adj.add(new Vertex(i));
    }
  }

  @Override
  public void addEdge(int v1, int v2) {
    if (v1 < 0 || v1 >= this.numVertices || v2 < 0 || v2 >= this.numVertices) {
      throw new IllegalArgumentException("invalid vertex");
    }

    this.adj.get(v1).addEdge(v2);
    if (this.graphType == Graph.GraphType.UNDIRECTED) {
      this.adj.get(v2).addEdge(v1);
    }
  }

  @Override
  public List<Integer> getAdjacentVertices(int v) {
    if (v < 0 || v >= this.numVertices) {
      throw new IllegalArgumentException("invalid vertex");
    }

    List<Integer> neighbours = new ArrayList<>();
    for (int vv : this.adj.get(v).getAdjacentVertices()) {
      neighbours.add(vv);
    }

    return neighbours;
  }

  @Override
  public int size() {
    return this.numVertices;
  }

  @Override
  public int getIndegree(int v) {
    if (this.graphType == Graph.GraphType.UNDIRECTED) {
      throw new IllegalStateException(
          "indegree is not defined for undirected graphs");
    }

    if (v < 0 || v >= this.numVertices) {
      throw new IllegalArgumentException("invalid vertex");
    }

    int indegree = 0;
    for (int i = 0; i < numVertices; i++) {
      if (this.adj.get(i).hasEdge(v)) {
        indegree++;
      }
    }

    return indegree;
  }
}
