public class FixedArrayQueue<T> implements Queue<T> {
  private T[] arr;
  private int front;
  private int rear;

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(int size) {
    this.arr = (T[]) new Object[size];
    this.front = 0;
    this.rear = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.rear == this.front;
  }

  @Override
  public boolean isFull() {
    return this.rear == this.arr.length;
  }

  @Override
  public void enqueue(T elem) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }

    this.arr[this.rear++] = elem;
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }

    return this.arr[this.front++];
  }

  public static void main(String[] args) throws Exception {
    Queue<Integer> q = new FixedArrayQueue<>(10);

    for (int i = 0; i < 10; i++) {
      q.enqueue(i);
    }

    System.out.println(q.isFull());
    System.out.println(q.isEmpty());

    while (!q.isEmpty()) {
      System.out.printf("%d ", q.dequeue());
    }
    System.out.println();
    System.out.println(q.isEmpty());
  }
}