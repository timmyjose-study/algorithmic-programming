import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LinkedListStack<T> {
  private LinkedList<T> arr;

  public LinkedListStack() { this.arr = new LinkedList<>(); }

  public boolean isEmpty() { return this.arr.isEmpty(); }

  public void push(T elem) { this.arr.addLast(elem); }

  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("stack empty");
    }

    T val = this.arr.removeLast();
    return val;
  }

  public T peek() {
    if (isEmpty()) {
      throw new RuntimeException("stack empty");
    }

    return this.arr.peekLast();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      LinkedListStack<Integer> st = new LinkedListStack<>();
      int n = in.nextInt();
      in.nextLine();

      while (n-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push":
          st.push(Integer.parseInt(cmd[1]));
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
          }
          System.out.println();
          break;

        case "peek":
          System.out.println(st.peek());
          break;

        default:
          throw new IllegalArgumentException("Invalid command: " + cmd[1]);
        }
      }
    }
  }
}