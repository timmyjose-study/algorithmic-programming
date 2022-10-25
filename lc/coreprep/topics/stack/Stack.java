public interface Stack<T> {
  void push(T elem);
  T pop();
  T peek();
  boolean isEmpty();
}

class StackOverflowException extends RuntimeException {
  public StackOverflowException() { super("stack overflow"); }
}

class StackUnderflowException extends RuntimeException {
  public StackUnderflowException() { super("stack overflow"); }
}