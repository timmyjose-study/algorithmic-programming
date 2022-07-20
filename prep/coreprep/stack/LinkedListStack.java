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
    Stack<Integer> st = new LinkedListStack<>();

    for (int i = 1; i <= 10; i++) {
      st.push(i);
    }

    while (!st.isEmpty()) {
      System.out.printf("%d ", st.pop());
    }
    System.out.println();
  }
}
