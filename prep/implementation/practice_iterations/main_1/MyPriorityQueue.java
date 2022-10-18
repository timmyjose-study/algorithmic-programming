import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class MyPriorityQueue<T> {
  private List<T> arr;
  private Comparator<T> comp;

  public MyPriorityQueue(Comparator<T> comp) {
    this.arr = new ArrayList<>();
    this.comp = comp;
  }

  private int left(int p) { return 2 * p + 1; }

  private int right(int p) { return 2 * p + 2; }

  private int parent(int p) { return p / 2; }

  private void swap(int x, int y) {
    T t = this.arr.get(x);
    this.arr.set(x, this.arr.get(y));
    this.arr.set(y, t);
  }

  private void siftUp(int p) {
    while (p >= 0 &&
           comp.compare(this.arr.get(p), this.arr.get(parent(p))) > 0) {
      swap(p, parent(p));
      p = parent(p);
    }
  }

  private void siftDown(int p) {
    int maxIdx = p;

    int leftIdx = left(p);
    if (leftIdx < size() &&
        comp.compare(this.arr.get(leftIdx), this.arr.get(maxIdx)) > 0) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(p);
    if (rightIdx < size() &&
        comp.compare(this.arr.get(rightIdx), this.arr.get(maxIdx)) > 0) {
      maxIdx = rightIdx;
    }

    if (maxIdx != p) {
      swap(maxIdx, p);
      siftDown(maxIdx);
    }
  }

  // O(logn)
  public void add(T elem) {
    this.arr.add(elem);
    siftUp(this.arr.size() - 1);
  }

  // O(logn)
  public T poll() {
    if (isEmpty()) {
      throw new IllegalStateException("empty priority queue");
    }

    T val = this.arr.get(0);
    swap(0, this.arr.size() - 1);
    this.arr.remove(this.arr.size() - 1);
    siftDown(0);

    return val;
  }

  // O(1)
  public boolean isEmpty() { return this.arr.isEmpty(); }

  // O(1)
  public int size() { return this.arr.size(); }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyPriorityQueue<Integer> maxHeap =
          new MyPriorityQueue<>((x, y) -> Integer.compare(x, y));
      MyPriorityQueue<Integer> minHeap =
          new MyPriorityQueue<>((x, y) -> Integer.compare(y, x));

      int n = in.nextInt();
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