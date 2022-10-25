import java.util.Scanner;

public class FixedArrayQueue<T> implements Queue<T> {
  private T[] arr;
  private int front;
  private int rear;

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(int size) {
    this.arr = (T[]) new Object[size];
    this.front = 0;
    this.rear = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.rear == this.front;
  }

  @Override
  public boolean isFull() {
    return this.rear == this.arr.length;
  }

  @Override
  public void enqueue(T elem) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }

    this.arr[this.rear++] = elem;
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }

    return this.arr[this.front++];
  }

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Queue<Integer> q = new FixedArrayQueue<>(n);

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