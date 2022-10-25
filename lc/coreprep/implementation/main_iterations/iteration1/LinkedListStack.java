import java.util.*;

@SuppressWarnings("unchecked")
public class LinkedListStack<T> implements MyStack<T> {
  private MyList<T> dll;

  public LinkedListStack() { this.dll = new DoublyLinkedList<>(); }

  // O(1)
  @Override
  public void push(T elem) {
    this.dll.pushBack(elem);
  }

  // O(1)
  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    return this.dll.popBack();
  }

  // O(1)
  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    T lastVal = this.dll.popBack();
    this.dll.pushBack(lastVal);

    return lastVal;
  }

  @Override
  public boolean isEmpty() {
    return this.dll.isEmpty();
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException("isfull");
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyStack<Integer> st = new LinkedListStack<>();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push": {
          int elem = Integer.parseInt(cmd[1]);
          st.push(elem);

        } break;

        case "pop":
          System.out.println(st.pop());
          break;

        case "peek":
          System.out.println(st.peek());
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;

        case "newline":
          System.out.println();
          break;

        default:
          throw new UnsupportedOperationException("invalid operation: " +
                                                  cmd[0]);
        }
      }
    }
  }
}