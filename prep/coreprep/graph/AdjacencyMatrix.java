import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements Graph {
  private int numVertices;
  private int[][] mat;
  private Graph.GraphType graphType;

  public AdjacencyMatrix(int numVertices) {
    this(numVertices, Graph.GraphType.UNDIRECTED);
  }

  public AdjacencyMatrix(int numVertices, Graph.GraphType graphType) {
    this.numVertices = numVertices;
    this.mat = new int[numVertices][numVertices];
    this.graphType = graphType;

    for (int i = 0; i < numVertices; i++) {
      for (int j = 0; j < numVertices; j++) {
        this.mat[i][j] = 0;
      }
    }
  }

  @Override
  public void addEdge(int v1, int v2) {
    if (v1 < 0 || v1 >= this.numVertices || v2 < 0 || v2 >= this.numVertices) {
      throw new IllegalArgumentException("invalid vertex");
    }

    this.mat[v1][v2] = 1;
    if (this.graphType == Graph.GraphType.UNDIRECTED) {
      this.mat[v2][v1] = 1;
    }
  }

  @Override
  public List<Integer> getAdjacentVertices(int v) {
    if (v < 0 || v >= this.numVertices) {
      throw new IllegalArgumentException("invalid vertex");
    }

    List<Integer> neighbours = new ArrayList<>();
    for (int i = 0; i < this.numVertices; i++) {
      if (this.mat[v][i] == 1) {
        neighbours.add(i);
      }
    }
    neighbours.sort((x, y) -> Integer.compare(x, y));

    return neighbours;
  }

  @Override
  public int size() {
    return this.numVertices;
  }
}