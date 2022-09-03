import java.util.*;

@SuppressWarnings("unchecked")
public class FixedArrayQueue<T> implements MyQueue<T> {
  private T[] arr;
  private int front;
  private int rear;
  private int size;

  public FixedArrayQueue(int size) {
    this.arr = (T[]) new Object[size];
    this.front = -1;
    this.rear = -1;
    this.size = 0;
  }

  @Override
  public void enqueue(T elem) {
    if (isFull()) {
      throw new IllegalStateException("queue full");
    }

    this.arr[++this.front] = elem;
    this.size++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }

    T val = this.arr[++this.rear];
    this.size--;

    return val;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean isFull() {
    return this.size == this.arr.length;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int size = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      MyQueue<Integer> q = new FixedArrayQueue<>(size);

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
          break;

        case "newline":
          System.out.println("\n");
          break;

        case "isfull":
          System.out.println(q.isFull());
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