import java.util.Scanner;

public class DynamicArrayStack<T> implements Stack<T> {
  private DynamicArray<T> arr;

  public DynamicArrayStack() { this.arr = new DynamicArray<>(); }

  @Override
  public void push(T elem) {
    this.arr.add(elem);
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }

    T val = this.arr.last();
    this.arr.remove(this.arr.size() - 1);

    return val;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }

    return this.arr.last();
  }

  @Override
  public boolean isEmpty() {
    return this.arr.isEmpty();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Stack<Integer> st = new DynamicArrayStack<>();

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

interface List<T> {
  void add(T elem);
  T last();
  T first();
  int size();
  void remove(int idx);
  public boolean isEmpty();
}

class ListEmptyException extends RuntimeException {
  public ListEmptyException() { super("empty list"); }
}

class DynamicArray<T> implements List<T> {
  private T[] arr;
  private int len;
  private int cap;

  @SuppressWarnings("unchecked")
  public DynamicArray() {
    this.arr = (T[]) new Object[1];
    this.len = 0;
    this.cap = 1;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void add(T elem) {
    if (len == cap) {
      this.cap *= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }

    this.arr[len++] = elem;
  }

  @Override
  public T first() {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    return this.arr[0];
  }

  @Override
  public T last() {
    if (isEmpty()) {
      throw new ListEmptyException();
    }

    return this.arr[this.len - 1];
  }

  @Override
  public int size() {
    return this.len;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void remove(int idx) {
    this.len--;

    for (int i = idx; i < len; i++) {
      this.arr[i] = this.arr[i + 1];
    }

    if (this.len < this.cap / 2) {
      this.cap /= 2;
      T[] newArr = (T[]) new Object[this.cap];
      System.arraycopy(this.arr, 0, newArr, 0, this.len);
      this.arr = newArr;
    }
  }

  @Override
  public boolean isEmpty() {
    return this.len == 0;
  }
}
