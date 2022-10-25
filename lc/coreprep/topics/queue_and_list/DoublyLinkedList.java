import java.util.Scanner;

public class DoublyLinkedList<T> implements List<T> {
  static class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    Node(T data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void pushFront(T elem) {
    Node<T> node = new Node<>(elem);
    if (this.head == null) {
      this.head = this.tail = node;
    } else {
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }

    this.size++;
  }

  @Override
  public void pushBack(T elem) {
    Node<T> node = new Node<>(elem);

    if (this.tail == null) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
    }

    this.size++;
  }

  @Override
  public T popFront() throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    this.size--;

    if (this.head == this.tail) {
      T data = this.head.data;
      this.head = this.tail = null;
      return data;
    }

    T data = this.head.data;
    this.head = this.head.next;
    this.head.prev = null;

    return data;
  }

  @Override
  public T popBack() throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    this.size--;

    if (this.tail == this.head) {
      T data = this.tail.data;
      this.tail = this.head = null;
      return data;
    }

    T data = this.tail.data;
    this.tail = this.tail.prev;
    this.tail.next = null;

    return data;
  }

  @Override
  public void removeIndex(int index) throws ListEmptyException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void removeElem(T elem) throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    Node<T> curr = this.head;
    while (curr != null && !curr.data.equals(elem)) {
      curr = curr.next;
    }

    if (curr == null) {
      return;
    }

    this.size--;
    if (curr == head && curr == tail) {
      this.head = this.tail = null;
    } else if (curr == this.head) {
      this.head = this.head.next;
      this.head.prev = null;
    } else if (curr == this.tail) {
      this.tail = this.tail.prev;
      this.tail.next = null;
    } else {
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "<EMPTY LIST>";
    }

    StringBuffer sb = new StringBuffer();
    for (Node<T> curr = this.head; curr != null; curr = curr.next) {
      sb.append(curr.data).append(" ");
    }

    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      List<Integer> dll = new DoublyLinkedList<>();

      while (n-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront":
          dll.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "popfront":
          System.out.printf("%d ", dll.popFront());
          break;

        case "tillemptypopfront":
          while (!dll.isEmpty()) {
            System.out.printf("%d ", dll.popFront());
          }
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypopback":
          while (!dll.isEmpty()) {
            System.out.printf("%d ", dll.popBack());
          }
          break;

        case "pushback":
          dll.pushBack(Integer.parseInt(cmd[1]));
          break;

        case "popback":
          System.out.printf("%d ", dll.popBack());
          break;

        case "removeelem":
          dll.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "print":
          System.out.println(dll);
          break;
        }
      }
    }
  }
}