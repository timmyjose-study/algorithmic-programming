import java.util.*;

public class DynamicArrayQueue<T> implements MyQueue<T> {
  private DynamicArray<T> dynArr;

  public DynamicArrayQueue() { this.dynArr = new DynamicArray<>(); }

  @Override
  public boolean isEmpty() {
    return this.dynArr.isEmpty();
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void enqueue(T elem) {
    this.dynArr.pushBack(elem);
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new UnsupportedOperationException("queue empty");
    }

    return this.dynArr.popFront();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyQueue<Integer> q = new DynamicArrayQueue<>();

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