public class Stack<T> {
  private T[] arr;
  private int top;

  @SuppressWarnings("unchecked")
  public Stack(int size) {
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

  public T top() {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }
    return this.arr[this.top];
  }
}

class StackOverflowException extends RuntimeException {
  public StackOverflowException() { super("stack overflow"); }
}

class StackUnderflowException extends RuntimeException {
  public StackUnderflowException() { super("stack underflow"); }
}