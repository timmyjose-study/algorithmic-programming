public interface MyStack<T> {
  void push(T elem);
  T pop();
  T peek();
  boolean isEmpty();
  boolean isFull();
}