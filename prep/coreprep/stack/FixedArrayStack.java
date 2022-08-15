import java.util.Scanner;

public class FixedArrayStack<T> implements Stack<T> {
  private T[] arr;
  private int top;

  @SuppressWarnings("unchecked")
  public FixedArrayStack(int size) {
    this.arr = (T[]) new Object[size];
    this.top = -1;
  }

  public boolean isEmpty() { return this.top == -1; }

  public void push(T elem) {
    if (this.top == this.arr.length) {
      throw new StackOverflowException();
    }

    this.arr[++this.top] = elem;
  }

  public T pop() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }

    T val = arr[this.top--];
    return val;
  }

  public T peek() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }
    return this.arr[this.top];
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      Stack<Integer> st = new FixedArrayStack<>(n);

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push":
          st.push(Integer.parseInt(cmd[1]));
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;

        case "newline":
          System.out.println();
          break;
        }
      }
    }
  }
}