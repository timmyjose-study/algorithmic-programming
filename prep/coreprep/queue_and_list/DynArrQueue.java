public class DynArrQueue<T> implements Queue<T> {
  private List<T> dynArr;

  public DynArrQueue() { this.dynArr = new DynamicArray<>(); }

  @Override
  public boolean isEmpty() {
    return this.dynArr.isEmpty();
  }

  @Override
  public boolean isFull() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void enqueue(T elem) {
    this.dynArr.pushBack(elem);
  }

  @Override
  public T dequeue() throws QueueUnderflowException {
    try {
      return this.dynArr.popFront();
    } catch (ListEmptyException ex) {
      throw new QueueUnderflowException();
    }
  }

  public static void main(String[] args) throws Exception {
    Queue<Integer> q = new DynArrQueue<>();

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
