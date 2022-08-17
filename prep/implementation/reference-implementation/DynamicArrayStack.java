import java.util.*;

public class DynamicArrayStack<T> implements MyStack<T> {
  private DynamicArray<T> arr;
  private int top;

  public DynamicArrayStack() {
    this.top = -1;
    this.arr = new DynamicArray<>();
  }

  @Override
  public void push(T elem) {
    this.arr.pushBack(elem);
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    return this.arr.popBack();
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("stack underflow");
    }

    return this.arr.get(this.arr.size() - 1);
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isEmpty() {
    return this.arr.isEmpty();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      MyStack<Integer> st = new DynamicArrayStack<>();

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