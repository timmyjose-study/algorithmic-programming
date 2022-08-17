import java.util.*;

public class CircularFixedArrayQueue<T> implements MyQueue<T> {
  private T[] arr;
  private int front;
  private int rear;
  private int size;

  @SuppressWarnings("unchecked")
  public CircularFixedArrayQueue(int maxSize) {
    this.front = this.rear = 0;
    this.arr = (T[]) new Object[maxSize];
    this.size = 0;
  }

  @Override
  public boolean isFull() {
    return this.size == this.arr.length;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void enqueue(T elem) {
    if (isFull()) {
      throw new IllegalStateException("queue full");
    }

    if (this.rear == this.arr.length) {
      this.rear = 0;
    }

    this.arr[this.rear++] = elem;
    this.size++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }

    T val = this.arr[this.front];
    this.front++;
    if (this.front == this.arr.length) {
      this.front = 0;
    }
    this.size--;

    return val;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      MyQueue<Integer> q = new CircularFixedArrayQueue<>(n);

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "isempty":
          System.out.println(q.isEmpty());
          break;

        case "isfull":
          System.out.println(q.isFull());
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
          System.out.println();
        }
      }
    }
  }
}