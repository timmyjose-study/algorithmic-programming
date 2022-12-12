import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FixedArrayStack<T> {
  private T[] arr;
  private int topOfStack;

  @SuppressWarnings("unchecked")
  public FixedArrayStack(int size) {
    this.arr = (T[]) new Object[size];
    this.topOfStack = -1;
  }

  public void push(T elem) {
    if (isFull()) {
      throw new RuntimeException("stack full");
    }

    this.arr[++this.topOfStack] = elem;
  }

  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("stack empty");
    }

    return this.arr[this.topOfStack--];
  }

  public T peek() {
    if (isEmpty()) {
      throw new RuntimeException("stack empty");
    }

    return this.arr[this.topOfStack];
  }

  public boolean isEmpty() { return this.topOfStack == -1; }

  public boolean isFull() { return this.topOfStack == this.arr.length; }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      FixedArrayStack<Integer> st = new FixedArrayStack<>(n);
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- > 0) {
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
        }
      }
    }
  }
}