import java.util.*;

@SuppressWarnings("unchecked")
public class CircularFixedArrayQueue<T> implements MyQueue<T> {
  private static final int DEFAULT_SIZE = 1024;

  private T[] arr;
  private int front;
  private int rear;
  private int size;

  public CircularFixedArrayQueue() {
    this(CircularFixedArrayQueue.DEFAULT_SIZE);
  }

  public CircularFixedArrayQueue(int size) {
    this.size = 0;
    this.arr = (T[]) new Object[size];
    this.front = this.rear = 0;
  }

  @Override
  public void enqueue(T elem) {
    if (this.front == this.arr.length) {
      this.front = 0;
    }

    this.size++;
    this.arr[this.front++] = elem;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }

    T val = this.arr[this.rear++];
    this.size--;

    if (this.rear == this.arr.length) {
      this.rear = 0;
    }

    return val;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException("is full");
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int size = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      MyQueue<Integer> q = new CircularFixedArrayQueue<>(size);

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "enqueue": {
          int elem = Integer.parseInt(cmd[1]);
          q.enqueue(elem);
        } break;

        case "dequeue":
          System.out.println(q.dequeue());
          break;

        case "tillemptydequeue":
          while (!q.isEmpty()) {
            System.out.printf("%d ", q.dequeue());
          }
          System.out.println();
          break;

        case "isempty":
          System.out.println(q.isEmpty());
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}