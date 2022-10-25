import java.util.*;

public class DoublyLinkedList<T extends Comparable<T>> implements MyList<T> {
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

  public DoublyLinkedList() { this.head = this.tail = null; }

  @Override
  public void pushFront(T elem) {
    if (this.head == null) {
      this.head = this.tail = new Node<>(elem);
    } else {
      Node<T> newNode = new Node<>(elem);
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
    }

    this.size++;
  }

  @Override
  public void pushBack(T elem) {
    if (this.tail == null) {
      this.tail = this.head = new Node<>(elem);
    } else {
      Node<T> newNode = new Node<>(elem);
      newNode.prev = this.tail;
      this.tail.next = newNode;
      this.tail = newNode;
    }
    this.size++;
  }

  @Override
  public T popFront() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = null;
    if (this.head == this.tail) {
      val = this.head.data;
      this.head = this.tail = null;
    } else {
      val = this.head.data;
      if (this.head.next != null) {
        this.head.next.prev = null;
      }
      this.head = this.head.next;
    }
    this.size--;

    return val;
  }

  @Override
  public T popBack() {
    if (isEmpty()) {
      throw new IllegalStateException("empty list");
    }

    T val = null;

    if (this.head == this.tail) {
      val = this.tail.data;
      this.tail = this.head = null;
    } else {
      val = this.tail.data;
      this.tail.prev.next = null;
      this.tail = this.tail.prev;
    }

    this.size--;

    return val;
  }

  @Override
  public T get(int idx) {
    throw new UnsupportedOperationException("get");
  }

  @Override
  public void removeElem(T elem) {
    if (isEmpty()) {
      return;
    }

    if (this.head == this.tail && this.head.data.compareTo(elem) == 0) {
      this.head = this.tail = null;
    } else if (this.head.data.compareTo(elem) == 0) {
      popFront();
      return;
    } else {
      Node<T> currNode = this.head;
      while (currNode != null && currNode.data.compareTo(elem) != 0) {
        currNode = currNode.next;
      }

      if (currNode == null) {
        return;
      }

      if (currNode.prev != null) {
        currNode.prev.next = currNode.next;
      }

      if (currNode.next != null) {
        currNode.next.prev = currNode.prev;
      }
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
    Node<T> currNode = this.head;
    while (currNode != null) {
      sb.append(currNode.data).append(" ");
      currNode = currNode.next;
    }

    return sb.toString().trim();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyList<Integer> dll = new DoublyLinkedList<>();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          dll.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          dll.pushBack(elem);
        } break;

        case "popfront":
          System.out.printf("%d ", dll.popFront());
          break;

        case "popback":
          System.out.printf("%d ", dll.popBack());
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          dll.removeElem(elem);
        } break;

        case "print":
          System.out.println(dll);
          break;

        case "newline":
          System.out.println();
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

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}