import java.util.*;

@SuppressWarnings("unchecked")
public class CircularFixedArrayQueue<T> implements MyQueue<T> {
  private T[] arr;
  private int front;
  private int rear;
  private int size;

  public CircularFixedArrayQueue(int capacity) {
    this.arr = (T[]) new Object[capacity];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  @Override
  public void enqueue(T elem) {
    if (this.rear == this.arr.length) {
      this.rear = 0;
    }

    this.arr[this.front++] = elem;
    if (this.front == this.arr.length) {
      this.front = 0;
    }
    this.size++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }

    T val = this.arr[this.rear++];
    if (this.rear == this.arr.length) {
      this.rear = 0;
    }
    this.size--;

    return val;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException("isFull");
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      MyQueue<Integer> q = new CircularFixedArrayQueue<>(n);
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "isempty":
          System.out.println(q.isEmpty());
          break;

        case "enqueue":
          q.enqueue(Integer.parseInt(cmd[1]));
          break;

        case "dequeue":
          System.out.println(q.dequeue());
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptydequeue":
          while (!q.isEmpty()) {
            System.out.printf("%d ", q.dequeue());
          }
          break;
        }
      }
    }
  }
}