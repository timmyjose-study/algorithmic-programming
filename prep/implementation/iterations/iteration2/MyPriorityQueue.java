import java.util.*;

public class MyPriorityQueue<T extends Comparable<T>> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      MyPriorityQueue<Integer> maxHeap = new MyPriorityQueue<>();
      MyPriorityQueue<Integer> minHeap =
          new MyPriorityQueue<>((p, q) -> q.compareTo(p));

      for (int i = 0; i < n; i++) {
        int elem = in.nextInt();
        maxHeap.add(elem);
        minHeap.add(elem);
      }

      System.out.println(maxHeap.isEmpty());
      while (!maxHeap.isEmpty()) {
        System.out.printf("%d ", maxHeap.poll());
      }
      System.out.println();
      System.out.println(maxHeap.isEmpty());

      System.out.println(minHeap.isEmpty());
      while (!minHeap.isEmpty()) {
        System.out.printf("%d ", minHeap.poll());
      }
      System.out.println();
      System.out.println(minHeap.isEmpty());
    }
  }
}