import java.util.*;

public class MyPriorityQueue<T extends Comparable<T>> {
  private List<T> arr;
  private Comparator<? super T> comp;

  public MyPriorityQueue() { this((p, q) -> p.compareTo(q)); }

  public MyPriorityQueue(Comparator<? super T> comp) {
    this.arr = new ArrayList<>();
    this.comp = comp;
  }

  public void add(T elem) {
    this.arr.add(elem);
    siftUp(size() - 1);
  }

  public T poll() {
    if (isEmpty()) {
      throw new IllegalStateException("empty priority queue");
    }

    T val = this.arr.get(0);
    swap(0, size() - 1);
    arr.remove(arr.size() - 1);
    siftDown(0);

    return val;
  }

  private void siftUp(int pos) {
    while ((pos > 0) && (this.comp.compare(this.arr.get(pos),
                                           this.arr.get(parent(pos))) > 0)) {
      swap(pos, parent(pos));
      pos = parent(pos);
    }
  }

  private int parent(int pos) { return pos / 2; }

  private int left(int pos) { return 2 * pos + 1; }

  private int right(int pos) { return 2 * pos + 2; }

  private void siftDown(int pos) {
    int maxIdx = pos;

    int leftIdx = left(pos);
    if (leftIdx < size() &&
        this.comp.compare(this.arr.get(maxIdx), this.arr.get(leftIdx)) < 0) {
      maxIdx = leftIdx;
    }

    int rightIdx = right(pos);
    if (rightIdx < size() &&
        this.comp.compare(this.arr.get(maxIdx), this.arr.get(rightIdx)) < 0) {
      maxIdx = rightIdx;
    }

    if (maxIdx != pos) {
      swap(maxIdx, pos);
      siftDown(maxIdx);
    }
  }

  private void swap(int x, int y) {
    T tmp = this.arr.get(x);
    this.arr.set(x, this.arr.get(y));
    this.arr.set(y, tmp);
  }

  public boolean isEmpty() { return size() == 0; }

  public int size() { return this.arr.size(); }

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