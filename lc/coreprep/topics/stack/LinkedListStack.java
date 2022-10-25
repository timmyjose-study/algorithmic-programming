import java.util.Scanner;

public class LinkedListStack<T> implements Stack<T> {
  static class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<T> head;
  private int pos;

  public LinkedListStack() {
    this.head = null;
    this.pos = 0;
  }

  @Override
  public void push(T elem) {
    if (this.head == null) {
      this.head = new Node<>(elem, null);
      this.pos++;
    } else {
      Node<T> node = new Node<>(elem, this.head);
      this.head = node;
      this.pos++;
    }
  }

  @Override
  public boolean isEmpty() {
    return this.pos == 0;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }
    T val = this.head.data;
    this.head = this.head.next;
    this.pos--;

    return val;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }
    return this.head.data;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Stack<Integer> st = new LinkedListStack<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push":
          st.push(Integer.parseInt(cmd[1]));
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;

        case "newline":
          System.out.println();
          break;
        }
      }
    }
  }
}
