import java.util.*;

public class LinkedListStack<T> implements MyStack<T> {
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

    T lastElem = this.dll.popBack();
    this.dll.pushBack(lastElem);

    return lastElem;
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isEmpty() {
    return this.dll.isEmpty();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyStack<Integer> st = new LinkedListStack<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push":
          st.push(Integer.parseInt(cmd[1]));
          break;

        case "pop":
          System.out.printf("%d ", st.pop());
          break;

        case "peek":
          System.out.println(st.peek());
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;
        }
      }
    }
  }
}