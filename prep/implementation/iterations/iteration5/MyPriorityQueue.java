import java.util.*;

public class MyPriorityQueue<T extends Comparable<T>> {
  private List<T> arr;
  private Comparator<? super T> comp;

  MyPriorityQueue() { this((p, q) -> p.compareTo(q)); }

  MyPriorityQueue(Comparator<? super T> comp) {
    this.comp = comp;
    this.arr = new ArrayList<>();
  }

  private int parent(int p) { return p / 2; }

  private int left(int p) { return 2 * p + 1; }

  private int right(int p) { return 2 * p + 2; }

  private void swap(int p, int q) {
    T t = this.arr.get(p);
    this.arr.set(p, this.arr.get(q));
    this.arr.set(q, t);
  }

  private void siftUp(int p) {
    while (p != 0 &&
           comp.compare(this.arr.get(p), this.arr.get(parent(p))) > 0) {
      swap(p, parent(p));
      p = parent(p);
    }
  }

  private void siftDown(int p) {
    int maxIdx = p;

    int leftIdx = left(p);
    if (leftIdx < this.arr.size() &&
        comp.compare(this.arr.get(leftIdx), this.arr.get(maxIdx)) > 0) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(p);
    if (rightIdx < this.arr.size() &&
        comp.compare(this.arr.get(rightIdx), this.arr.get(maxIdx)) > 0) {
      maxIdx = rightIdx;
    }

    if (maxIdx != p) {
      swap(p, maxIdx);
      siftDown(maxIdx);
    }
  }

  public void add(T elem) {
    this.arr.add(elem);
    siftUp(this.arr.size() - 1);
  }

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

  public boolean isEmpty() { return this.arr.size() == 0; }

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