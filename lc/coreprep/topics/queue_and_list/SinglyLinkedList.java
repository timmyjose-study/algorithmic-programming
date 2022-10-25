import java.util.Scanner;

public class SinglyLinkedList<T extends Comparable<T>> implements List<T> {
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

  public SinglyLinkedList() {
    this.head = null;
    this.size = 0;
  }

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
  public T popFront() throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    Node<T> node = this.head;
    this.head = this.head.next;
    this.size--;

    return node.data;
  }

  @Override
  public T popBack() throws ListEmptyException {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    Node<T> curr = this.head;
    Node<T> prev = null;
    while (curr != null && curr.next != null) {
      prev = curr;
      curr = curr.next;
    }

    T data = null;
    if (prev == null) {
      data = this.head.data;
      this.head = null;
    } else {
      data = curr.data;
      prev.next = null;
    }

    this.size--;

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
    Node<T> prev = null;
    while (curr != null && !curr.data.equals(elem)) {
      prev = curr;
      curr = curr.next;
    }

    if (curr == null) {
      return;
    }

    this.size--;
    if (curr == head) {
      this.head = this.head.next;
    } else {
      prev.next = curr.next;
    }
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "<EMPTY LIST>";
    }

    StringBuffer sb = new StringBuffer();
    Node<T> curr = this.head;
    while (curr != null) {
      sb.append(curr.data).append(" ");
      curr = curr.next;
    }

    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      List<Integer> sll = new SinglyLinkedList<>();

      while (n-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront":
          sll.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "popfront":
          System.out.printf("%d ", sll.popFront());
          break;

        case "tillemptypopfront":
          while (!sll.isEmpty()) {
            System.out.printf("%d ", sll.popFront());
          }
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypopback":
          while (!sll.isEmpty()) {
            System.out.printf("%d ", sll.popBack());
          }
          break;

        case "pushback":
          sll.pushBack(Integer.parseInt(cmd[1]));
          break;

        case "popback":
          System.out.printf("%d ", sll.popBack());
          break;

        case "removeelem":
          sll.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "print":
          System.out.println(sll);
          break;
        }
      }
    }
  }
}
