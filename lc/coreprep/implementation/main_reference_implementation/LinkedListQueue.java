import java.util.*;

public class LinkedListQueue<T> implements MyQueue<T> {
  private DoublyLinkedList<T> dll;

  public LinkedListQueue() { this.dll = new DoublyLinkedList<>(); }

  @Override
  public boolean isEmpty() {
    return this.dll.isEmpty();
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException("queue empty");
  }

  @Override
  public void enqueue(T elem) {
    this.dll.pushBack(elem);
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }

    return this.dll.popFront();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyQueue<Integer> q = new LinkedListQueue<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "enqueue":
          q.enqueue(Integer.parseInt(cmd[1]));
          break;

        case "dequeue":
          System.out.println(q.dequeue());
          break;

        case "isempty":
          System.out.println(q.isEmpty());
          break;

        case "isfull":
          System.out.println(q.isFull());
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