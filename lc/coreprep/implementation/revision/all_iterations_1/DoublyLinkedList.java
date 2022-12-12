import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class DoublyLinkedList {
  static class DLL<T extends Comparable<T>> {
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

    DLL() {
      this.head = this.tail = null;
      this.size = 0;
    }

    // O(1)
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

    // O(1)
    public T popFront() {
      if (isEmpty()) {
        throw new RuntimeException("empty dll");
      }

      if (this.head == this.tail) {
        T val = this.head.data;
        this.head = this.tail = null;
        this.size--;

        return val;
      }

      T val = this.head.data;
      this.head.next.prev = null;
      this.head = this.head.next;
      this.size--;

      return val;
    }

    // O(1)
    public void pushBack(T elem) {
      if (this.tail == null) {
        this.head = this.tail = new Node<>(elem);
      } else {
        Node<T> node = new Node<>(elem);
        node.prev = tail;
        this.tail.next = node;
        this.tail = node;
      }
      this.size++;
    }

    // O(1)
    public T popBack() {
      if (isEmpty()) {
        throw new RuntimeException("empty dll");
      }

      if (this.tail == this.head) {
        T val = this.tail.data;
        this.tail = this.head = null;
        this.size--;
        return val;
      }

      T val = this.tail.data;
      this.tail.prev.next = null;
      this.tail = this.tail.prev;
      this.size--;

      return val;
    }

    // O(n)
    public void removeElem(T elem) {
      if (isEmpty()) {
        return;
      }

      if (this.head == this.tail) {
        if (this.head.data.compareTo(elem) == 0) {
          this.head = this.tail = null;
          this.size--;
        }
        return;
      }

      Node<T> curr = this.head;
      while (curr != null && curr.data.compareTo(elem) != 0) {
        curr = curr.next;
      }

      if (curr == null) {
        return;
      }

      if (curr == this.head) {
        this.head.next.prev = null;
        this.head = this.head.next;
      } else if (curr == this.tail) {
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
      } else {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
      }
      this.size--;
    }

    // O(1)
    public int size(T elem) { return this.size; }

    // O(1)
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public String toString() {
      if (isEmpty()) {
        return "<EMPTY LIST>";
      }

      StringBuilder sb = new StringBuilder();
      Node<T> curr = this.head;
      while (curr != null) {
        sb.append(curr.data).append(" ");
        curr = curr.next;
      }

      return sb.toString();
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      DLL<Integer> dll = new DLL<>();
      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront":
          dll.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "popfront":
          System.out.print(dll.popFront() + " ");
          break;

        case "pushback":
          dll.pushBack(Integer.parseInt(cmd[1]));
          break;

        case "popback":
          System.out.print(dll.popBack() + " ");
          break;

        case "tillemptypopfront":
          while (!dll.isEmpty()) {
            System.out.print(dll.popFront() + " ");
          }
          break;

        case "tillemptypopback":
          while (!dll.isEmpty()) {
            System.out.print(dll.popBack() + " ");
          }
          break;

        case "removeelem":
          dll.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "print":
          System.out.println(dll.toString());
          break;

        case "newline":
          System.out.println();
          break;

        default:
          throw new IllegalArgumentException("Invalid command: " + cmd[0]);
        }
      }
    }
  }
}