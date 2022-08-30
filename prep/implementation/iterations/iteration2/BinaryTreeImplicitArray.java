import java.util.*;
import java.util.function.Function;

public class BinaryTreeImplicitArray {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] nodes = in.nextLine().trim().split(" ");

      BinaryTree<Integer> tree = new BinaryTree<>(nodes.length);
      tree.build(nodes, Integer::parseInt);

      tree.dfsPreOrder();
      tree.dfsPreOrderIter();
      tree.dfsInOrder();
      tree.dfsInOrderIter();
      tree.dfsPostOrder();
      tree.dfsPostOrderIter();
      tree.bfs();
      tree.bfsRec();
    }
  }
}