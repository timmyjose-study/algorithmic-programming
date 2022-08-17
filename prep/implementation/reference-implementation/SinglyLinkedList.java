import java.util.*;

public class SinglyLinkedList<T> implements MyList<T> {
  static class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node<T> head;
  private int size;

  public SinglyLinkedList() { this.size = 0; }

  @Override
  public void pushFront(T elem) {
    if (this.head == null) {
      this.head = new Node<>(elem);
    } else {
      Node<T> node = new Node<>(elem);
      node.next = this.head;
      this.head = node;
    }
    this.size++;
  }

  @Override
  public void pushBack(T elem) {
    if (this.head == null) {
      this.head = new Node<>(elem);
    } else {
      Node<T> curr = this.head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = new Node<>(elem);
    }
    this.size++;
  }

  @Override
  public T popFront() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = this.head.data;
    this.head = this.head.next;
    this.size--;

    return val;
  }

  @Override
  public T popBack() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    Node<T> prev = null;
    Node<T> curr = this.head;

    while (curr.next != null) {
      prev = curr;
      curr = curr.next;
    }

    T val = null;
    if (prev == null) {
      val = this.head.data;
      this.head = null;
    } else {
      val = curr.data;
      prev.next = null;
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

    if (this.head.data.equals(elem)) {
      popFront();
    } else {
      Node<T> prev = null;
      Node<T> curr = this.head;
      while (curr != null && !curr.data.equals(elem)) {
        prev = curr;
        curr = curr.next;
      }

      if (curr == null) {
        return;
      }

      prev.next = curr.next;
      this.size--;
    }
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
      MyList<Integer> sll = new SinglyLinkedList<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "popfront":
          System.out.printf("%d ", sll.popFront());
          break;

        case "popback":
          System.out.printf("%d ", sll.popBack());
          break;

        case "pushfront":
          sll.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "pushback":
          sll.pushBack(Integer.parseInt(cmd[1]));
          break;

        case "tillemptypopfront":
          while (!sll.isEmpty()) {
            System.out.printf("%d ", sll.popFront());
          }
          break;

        case "tillemptypopback":
          while (!sll.isEmpty()) {
            System.out.printf("%d ", sll.popBack());
          }
          break;

        case "removeelem":
          sll.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "newline":
          System.out.println();
          break;

        case "print":
          System.out.println(sll);
          break;
        }
      }
    }
  }
}