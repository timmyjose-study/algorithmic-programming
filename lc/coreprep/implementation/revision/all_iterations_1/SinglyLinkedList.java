import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class SinglyLinkedList {
  static class SLL<T extends Comparable<T>> {
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

    SLL() {
      this.head = null;
      this.size = 0;
    }

    // O(1)
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

    // O(1)
    public T popFront() {
      if (isEmpty()) {
        throw new RuntimeException("empty sll");
      }

      T val = this.head.data;
      this.head = this.head.next;
      this.size--;

      return val;
    }

    // O(n)
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

    // O(n)
    public T popBack() {
      if (isEmpty()) {
        throw new RuntimeException("empty sll");
      }

      if (this.head.next == null) {
        T val = this.head.data;
        this.head = null;
        this.size--;
        return val;
      }

      Node<T> prev = null, curr = this.head;
      while (curr.next != null) {
        prev = curr;
        curr = curr.next;
      }

      T val = curr.data;
      prev.next = null;
      this.size--;

      return val;
    }

    // O(n)
    public void removeElem(T elem) {
      if (isEmpty()) {
        return;
      }

      if (this.head.next == null) {
        if (this.head.data.compareTo(elem) == 0) {
          this.head = null;
          this.size--;
        }
        return;
      }

      Node<T> prev = null, curr = this.head;
      while (curr != null && (curr.data.compareTo(elem) != 0)) {
        prev = curr;
        curr = curr.next;
      }

      if (curr == null) {
        return;
      }

      if (prev == null) {
        this.head = this.head.next;
      } else {
        prev.next = curr.next;
      }
      this.size--;
    }

    // O(1)
    public boolean isEmpty() { return this.size == 0; }

    // O(1)
    public int size() { return this.size; }

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
      SLL<Integer> sll = new SLL<>();

      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront":
          sll.pushFront(Integer.parseInt(cmd[1]));
          break;

        case "pushback":
          sll.pushBack(Integer.parseInt(cmd[1]));
          break;

        case "popfront":
          System.out.print(sll.popFront() + " ");
          break;

        case "popback":
          System.out.print(sll.popBack() + " ");
          break;

        case "tillemptypopfront":
          while (!sll.isEmpty()) {
            System.out.print(sll.popFront() + " ");
          }
          break;

        case "tillemptypopback":
          while (!sll.isEmpty()) {
            System.out.print(sll.popBack() + " ");
          }
          break;

        case "removeelem":
          sll.removeElem(Integer.parseInt(cmd[1]));
          break;

        case "print":
          System.out.println(sll.toString());
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