import java.util.*;

public class DynamicArrayQueue<T extends Comparable<T>> implements MyQueue<T> {
  private DynamicArray<T> dynArr;

  public DynamicArrayQueue() { this.dynArr = new DynamicArray<>(); }

  @Override
  public void enqueue(T elem) {
    this.dynArr.pushBack(elem);
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("queue empty");
    }
    return this.dynArr.popFront();
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException("isFull");
  }

  @Override
  public boolean isEmpty() {
    return this.dynArr.isEmpty();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyQueue<Integer> q = new DynamicArrayQueue<>();
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