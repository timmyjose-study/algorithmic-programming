import java.util.*;

public class FixedArrayQueue<T> implements MyQueue<T> {
  private T[] arr;
  private int front;
  private int rear;

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(int size) {
    this.front = this.rear = 0;
    this.arr = (T[]) new Object[size];
  }

  @Override
  public void enqueue(T elem) {
    if (isFull()) {
      throw new IllegalStateException("queue full");
    }

    this.arr[this.rear++] = elem;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }

    return this.arr[this.front++];
  }

  @Override
  public boolean isEmpty() {
    return this.front == this.rear;
  }

  @Override
  public boolean isFull() {
    return this.rear == this.arr.length;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      MyQueue<Integer> q = new FixedArrayQueue<>(n);

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