import java.util.List;

public interface Graph {
  enum GraphType {
    UNDIRECTED,
    DIRECTED;
  }

  void addEdge(int v1, int v2);
  List<Integer> getAdjacentVertices(int v);
  int getIndegree(int v);
  int size();
}