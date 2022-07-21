public interface Queue<T> {
  void enqueue(T elem) throws QueueOverflowException;
  T dequeue() throws QueueUnderflowException;
  boolean isEmpty();
  boolean isFull();
}