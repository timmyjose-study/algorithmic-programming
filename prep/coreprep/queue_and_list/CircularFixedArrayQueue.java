public class CircularFixedArrayQueue<T> implements Queue<T> {
  private T[] arr;
  private int front;
  private int rear;
  private int size;

  @SuppressWarnings("unchecked")
  public CircularFixedArrayQueue(int size) {
    this.arr = (T[]) new Object[size];
    this.front = 0;
    this.rear = front = 0;
    this.size = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean isFull() {
    return this.size == this.arr.length;
  }

  @Override
  public void enqueue(T elem) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }

    this.rear++;
    if (this.rear == this.arr.length) {
      this.rear = 0;
    }

    this.arr[this.rear] = elem;
    this.size++;
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }

    this.front++;
    if (this.front == this.arr.length) {
      this.front = 0;
    }

    this.size--;

    return this.arr[this.front];
  }

  public static void main(String[] args) throws Exception {
    Queue<Integer> q = new CircularFixedArrayQueue<>(10);

    for (int i = 0; i < 10; i++) {
      q.enqueue(i);
    }

    System.out.println(q.isEmpty());

    while (!q.isEmpty()) {
      System.out.printf("%d ", q.dequeue());
    }
    System.out.println();
    System.out.println(q.isEmpty());

    for (int i = 0; i < 10; i++) {
      q.enqueue(i);
    }

    while (!q.isEmpty()) {
      System.out.printf("%d ", q.dequeue());
    }
    System.out.println();

    for (int i = 0; i < 10; i++) {
      q.enqueue(i);
    }

    for (int i = 0; i < 4; i++) {
      System.out.printf("%d ", q.dequeue());
    }
    System.out.println();

    q.enqueue(10);
    q.enqueue(11);
    q.enqueue(12);
    q.enqueue(13);

    while (!q.isEmpty()) {
      System.out.printf("%d ", q.dequeue());
    }

    System.out.println();
  }
}
