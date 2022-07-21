public class DLLQueue<T> implements Queue<T> {
  private List<T> dll;

  public DLLQueue() { this.dll = new DoublyLinkedList<>(); }

  @Override
  public void enqueue(T elem) throws QueueOverflowException {
    this.dll.pushBack(elem);
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    try {
      return this.dll.popFront();
    } catch (ListEmptyException ex) {
      throw new QueueUnderflowException();
    }
  }

  @Override
  public boolean isEmpty() {
    return this.dll.isEmpty();
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException();
  }

  public static void main(String[] args) throws Exception {
    Queue<Integer> q = new DLLQueue<>();

    for (int i = 0; i < 10; i++) {
      q.enqueue(i);
    }

    while (!q.isEmpty()) {
      System.out.printf("%d ", q.dequeue());
    }
    System.out.println();

    q.enqueue(100);
    q.enqueue(200);
    q.enqueue(300);
    q.enqueue(400);
    q.enqueue(500);

    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(99);
    q.enqueue(-11);

    while (!q.isEmpty()) {
      System.out.printf("%d ", q.dequeue());
    }
    System.out.println();
  }
}