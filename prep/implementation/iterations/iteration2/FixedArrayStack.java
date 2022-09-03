import java.util.*;

@SuppressWarnings("unchecked")
public class FixedArrayStack<T> implements MyStack<T> {
  private T[] arr;
  private int top;

  public FixedArrayStack(int size) {
    this.arr = (T[]) new Object[size];
    this.top = -1;
  }

  @Override
  public void push(T elem) {
    if (isFull()) {
      throw new IllegalStateException("stack overflow");
    }

    this.arr[++this.top] = elem;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    return this.arr[this.top--];
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("empty stack");
    }

    return this.arr[this.top];
  }

  @Override
  public boolean isEmpty() {
    return this.top == -1;
  }

  @Override
  public boolean isFull() {
    return this.top == this.arr.length;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int size = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      MyStack<Integer> st = new FixedArrayStack<>(size);
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push": {
          int elem = Integer.parseInt(cmd[1]);
          st.push(elem);

        } break;

        case "pop":
          System.out.println(st.pop());
          break;

        case "peek":
          System.out.println(st.peek());
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;

        case "newline":
          System.out.println();
          break;

        default:
          throw new UnsupportedOperationException("invalid operation: " +
                                                  cmd[0]);
        }
      }
    }
  }
}