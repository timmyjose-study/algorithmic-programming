import java.util.*;

public class DoublyLinkedList<T> implements MyList<T> {
  static class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    Node(T data) {
      this.data = data;
      this.prev = this.next = null;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoublyLinkedList() { this.size = 0; }

  @Override
  public void pushFront(T elem) {
    if (this.head == null) {
      this.head = this.tail = new Node<>(elem);
    } else {
      Node<T> node = new Node<>(elem);
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }

    this.size++;
  }

  @Override
  public void pushBack(T elem) {
    if (this.tail == null) {
      this.head = this.tail = new Node<>(elem);
    } else {
      Node<T> node = new Node<>(elem);
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
    }
    this.size++;
  }

  @Override
  public T popFront() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.head.data;
    if (this.head == this.tail) {
      this.head = this.tail = null;
    } else {
      this.head = this.head.next;
      this.head.prev = null;
    }
    this.size--;

    return val;
  }

  @Override
  public T popBack() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.tail.data;
    if (this.tail == this.head) {
      this.tail = this.head = null;
    } else {
      this.tail = this.tail.prev;
      this.tail.next = null;
    }
    this.size--;

    return val;
  }

  @Override
  public T get(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void removeElem(T elem) {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    Node<T> curr = this.head;
    while (curr != null && !curr.data.equals(elem)) {
      curr = curr.next;
    }

    if (curr == null) {
      return;
    }

    if (curr == this.head) {
      this.head = this.head.next;
    } else if (curr == this.tail) {
      this.tail = this.tail.prev;
      this.tail.next = null;
    } else {
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }

    this.size--;
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
  public String toString() {
    if (isEmpty()) {
      return "<EMPTY LIST>";
    }

    StringBuilder sb = new StringBuilder();
    Node<T> curr = this.head;
    while (curr != null) {
      sb.append(curr.data + " ");
      curr = curr.next;
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyList<Integer> dll = new DoublyLinkedList<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "popfront":
          System.out.printf("%d ", dll.popFront());
          break;

        case "popback":
          System.out.printf("%d ", dll.popBack());
          break;

        case "pushfront":
          dll.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "pushback":
          dll.pushBack(Integer.parseInt(cmd[1]));
          break;

        case "tillemptypopfront":
          while (!dll.isEmpty()) {
            System.out.printf("%d ", dll.popFront());
          }
          break;

        case "tillemptypopback":
          while (!dll.isEmpty()) {
            System.out.printf("%d ", dll.popBack());
          }
          break;

        case "removeelem":
          dll.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "newline":
          System.out.println();
          break;

        case "print":
          System.out.println(dll);
          break;
        }
      }
    }
  }
}