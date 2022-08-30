public interface MyQueue<T> {
  void enqueue(T elem);
  T dequeue();
  boolean isEmpty();
  boolean isFull();
}