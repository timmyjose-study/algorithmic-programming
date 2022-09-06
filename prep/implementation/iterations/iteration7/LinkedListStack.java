import java.util.*;

@SuppressWarnings("unchecked")
public class LinkedListStack<T extends Comparable<T>> implements MyStack<T> {
  private DoublyLinkedList<T> dll;

  public LinkedListStack() { this.dll = new DoublyLinkedList<>(); }

  @Override
  public void push(T elem) {
    this.dll.pushBack(elem);
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    return this.dll.popBack();
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    T val = this.dll.popBack();
    this.dll.pushBack(val);

    return val;
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException("isFull");
  }

  @Override
  public boolean isEmpty() {
    return this.dll.isEmpty();
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