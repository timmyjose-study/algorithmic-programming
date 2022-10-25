import java.util.*;

public class FixedArrayStack<T> implements MyStack<T> {
  private T[] arr;
  private int top = -1;

  @SuppressWarnings("unchecked")
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
      throw new IllegalStateException("stack underflow");
    }

    return this.arr[this.top];
  }

  @Override
  public boolean isFull() {
    return this.top == this.arr.length;
  }

  @Override
  public boolean isEmpty() {
    return this.top == -1;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      MyStack<Integer> st = new FixedArrayStack<>(n);

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push":
          st.push(Integer.parseInt(cmd[1]));
          break;

        case "pop":
          System.out.printf("%d ", st.pop());
          break;

        case "peek":
          System.out.println(st.peek());
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;
        }
      }
    }
  }
}