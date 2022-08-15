import java.util.Scanner;

public class CircularFixedArrayQueue<T> implements Queue<T> {
  private T[] arr;
  private int front;
  private int rear;
  private int size;

  @SuppressWarnings("unchecked")
  public CircularFixedArrayQueue(int size) {
    this.arr = (T[]) new Object[size];
    this.front = 0;
    this.rear = front = 0;
    this.size = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean isFull() {
    return this.size == this.arr.length;
  }

  @Override
  public void enqueue(T elem) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }

    this.rear++;
    if (this.rear == this.arr.length) {
      this.rear = 0;
    }

    this.arr[this.rear] = elem;
    this.size++;
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }

    this.front++;
    if (this.front == this.arr.length) {
      this.front = 0;
    }

    this.size--;

    return this.arr[this.front];
  }

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Queue<Integer> q = new CircularFixedArrayQueue<>(n);

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "enqueue":
          q.enqueue(Integer.parseInt(cmd[1]));
          break;

        case "tillemptydequeue":
          while (!q.isEmpty()) {
            System.out.printf("%d ", q.dequeue());
          }
          break;

        case "newline":
          System.out.println();
          break;

        case "isfull":
          System.out.println(q.isFull());
          break;

        case "isempty":
          System.out.println(q.isEmpty());
          break;
        }
      }
    }
  }
}
