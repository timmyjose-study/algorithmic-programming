import java.util.*;

public class MyPriorityQueue<T extends Comparable<T>> {
  private List<T> arr;
  private int size;
  private Comparator<? super T> comp;

  private static final int DEFAULT_SIZE = 1024;

  public MyPriorityQueue(Comparator<? super T> comp) {
    this.arr = new ArrayList<>(DEFAULT_SIZE);
    this.size = 0;
    this.comp = comp;
  }

  public MyPriorityQueue() { this((T l, T r) -> l.compareTo(r)); }

  private int parent(int idx) { return idx / 2; }

  private int left(int idx) { return 2 * idx + 1; }

  private int right(int idx) { return 2 * idx + 2; }

  private void swap(int x, int y) {
    T t = this.arr.get(x);
    this.arr.set(x, this.arr.get(y));
    this.arr.set(y, t);
  }

  private void siftDown(int idx) {
    int maxIdx = idx;

    int leftIdx = left(idx);
    if (leftIdx < this.size &&
        comp.compare(this.arr.get(maxIdx), this.arr.get(leftIdx)) < 0) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(idx);
    if (rightIdx < this.size &&
        comp.compare(this.arr.get(maxIdx), this.arr.get(right(idx))) < 0) {
      maxIdx = rightIdx;
    }

    if (maxIdx != idx) {
      swap(idx, maxIdx);
      siftDown(maxIdx);
    }
  }

  private void siftUp(int idx) {
    while (idx > 0 &&
           comp.compare(this.arr.get(parent(idx)), this.arr.get(idx)) < 0) {
      swap(idx, parent(idx));
      idx = parent(idx);
    }
  }

  public void add(T elem) {
    this.arr.add(elem);
    this.size++;
    siftUp(this.size - 1);
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("empty queue");
    }

    return this.arr.get(0);
  }

  public T poll() {
    if (isEmpty()) {
      throw new IllegalStateException("empty queue");
    }

    T val = this.arr.get(0);
    this.arr.set(0, this.arr.get(this.size - 1));
    this.size--;
    siftDown(0);

    return val;
  }

  public boolean isEmpty() { return this.size == 0; }

  public int size() { return this.size; }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyPriorityQueue<Integer> maxQueue = new MyPriorityQueue<>();
      MyPriorityQueue<Integer> minQueue =
          new MyPriorityQueue<>((l, r) -> r.compareTo(l));

      int n = in.nextInt();
      for (int i = 0; i < n; i++) {
        int elem = in.nextInt();
        maxQueue.add(elem);
        minQueue.add(elem);
      }

      System.out.println(maxQueue.isEmpty());
      while (!maxQueue.isEmpty()) {
        System.out.printf("%d ", maxQueue.poll());
      }
      System.out.println();
      System.out.println(maxQueue.isEmpty());

      System.out.println(minQueue.isEmpty());
      while (!minQueue.isEmpty()) {
        System.out.printf("%d ", minQueue.poll());
      }
      System.out.println();
      System.out.println(minQueue.isEmpty());
    }
  }
}