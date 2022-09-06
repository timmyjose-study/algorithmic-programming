import java.util.*;

public class SinglyLinkedList<T extends Comparable<T>> implements MyList<T> {
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
      Node<T> newNode = new Node<>(elem);
      newNode.next = this.head;
      this.head = newNode;
    }
    this.size++;
  }

  @Override
  public void pushBack(T elem) {
    if (this.head == null) {
      this.head = new Node<>(elem);
    } else {
      Node<T> currNode = this.head;
      while (currNode.next != null) {
        currNode = currNode.next;
      }

      Node<T> newNode = new Node<>(elem);
      currNode.next = newNode;
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

    T val = null;
    if (this.head.next == null) {
      val = this.head.data;
      this.head = null;
    } else {

      Node<T> prev = null;
      Node<T> currNode = this.head;

      while (currNode.next != null) {
        prev = currNode;
        currNode = currNode.next;
      }

      val = currNode.data;
      if (prev != null) {
        prev.next = null;
      }
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

    if (this.head.data.compareTo(elem) == 0) {
      this.head = this.head.next;
    } else {
      Node<T> prevNode = null;
      Node<T> currNode = this.head;

      while (currNode != null && currNode.data.compareTo(elem) != 0) {
        prevNode = currNode;
        currNode = currNode.next;
      }

      if (currNode == null) {
        return;
      }

      if (prevNode != null) {
        prevNode.next = currNode.next;
      }
    }
    this.size--;
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

      MyList<Integer> sll = new SinglyLinkedList<>();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          sll.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          sll.pushBack(elem);
        } break;

        case "popfront":
          System.out.printf("%d ", sll.popFront());
          break;

        case "popback":
          System.out.printf("%d ", sll.popBack());
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          sll.removeElem(elem);
        } break;

        case "print":
          System.out.println(sll);
          break;

        case "newline":
          System.out.println();
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

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}