import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PriorityQueue<T extends Comparable<T>> {
  private List<T> arr;
  private Comparator<? super T> comp;
  private int size;

  private static final int INITIAL_CAPACITY = 1024;

  public PriorityQueue() { this((T l, T r) -> l.compareTo(r)); }

  public PriorityQueue(Comparator<? super T> comp) {
    this.arr = new ArrayList<>(PriorityQueue.INITIAL_CAPACITY);
    this.comp = comp;
    this.size = 0;
  }

  private int parent(int idx) { return idx / 2; }
  private int left(int idx) { return 2 * idx + 1; }
  private int right(int idx) { return 2 * idx + 2; }

  private void siftUp(int idx) {
    while (idx > 0 && this.comp.compare(this.arr.get(parent(idx)),
                                        this.arr.get(idx)) < 0) {
      swap(idx, parent(idx));
      idx = parent(idx);
    }
  }

  private void siftDown(int idx) {
    int maxIdx = idx;

    int l = left(idx);
    if (l<size &&this.comp.compare(this.arr.get(l), this.arr.get(maxIdx))> 0) {
      maxIdx = l;
    }

    int r = right(idx);
    if (r<size &&this.comp.compare(this.arr.get(r), this.arr.get(maxIdx))> 0) {
      maxIdx = r;
    }

    if (idx != maxIdx) {
      swap(idx, maxIdx);
      siftDown(maxIdx);
    }
  }

  private void swap(int idx1, int idx2) {
    T tmp = this.arr.get(idx1);
    this.arr.set(idx1, this.arr.get(idx2));
    this.arr.set(idx2, tmp);
  }

  public boolean isEmpty() { return this.size == 0; }

  private void add(T elem) {
    this.arr.add(elem);
    this.size++;
    siftUp(this.size - 1);
  }

  private T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("priority queue is empty");
    }

    return this.arr.get(0);
  }

  private T poll() {
    if (isEmpty()) {
      throw new IllegalStateException("priority queue is empty");
    }

    T res = this.arr.get(0);
    this.arr.set(0, this.arr.get(size - 1));
    this.size--;
    siftDown(0);

    return res;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
      PriorityQueue<Integer> minQueue =
          new PriorityQueue<>((l, r) -> r.compareTo(l));

      for (int i = 0; i < n; i++) {
        int d = in.nextInt();
        maxQueue.add(d);
        minQueue.add(d);
      }

      System.out.println("Max queue...");
      while (!maxQueue.isEmpty()) {
        System.out.printf("%s ", maxQueue.poll());
      }
      System.out.println();

      System.out.println("Min queue...");
      while (!minQueue.isEmpty()) {
        System.out.printf("%s ", minQueue.poll());
      }
      System.out.println();
    }
  }
}