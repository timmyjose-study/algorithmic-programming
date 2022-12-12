import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class DynamicArrayStack<T> {
  private List<T> arr;

  public DynamicArrayStack() { this.arr = new ArrayList<>(); }

  public void push(T elem) { this.arr.add(elem); }

  public boolean isEmpty() { return this.arr.isEmpty(); }

  public T pop() {
    if (this.arr.isEmpty()) {
      throw new RuntimeException("stack empty");
    }

    T val = this.arr.remove(this.arr.size() - 1);
    return val;
  }

  public T peek() {
    if (this.arr.isEmpty()) {
      throw new RuntimeException("stack empty");
    }

    return this.arr.get(this.arr.size() - 1);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      DynamicArrayStack<Integer> st = new DynamicArrayStack<>();
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
          throw new IllegalArgumentException("Invalid command: " + cmd[0]);
        }
      }
    }
  }
}