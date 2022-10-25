import java.util.Scanner;

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
    try (Scanner in = new Scanner(System.in)) {
      Queue<Integer> q = new DynArrQueue<>();

      int nq = in.nextInt();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "enqueue":
          q.enqueue(Integer.parseInt(cmd[1]));
          break;

        case "tillemptydequeue":
          while (!q.isEmpty()) {
            System.out.printf("%d ", q.dequeue());
          }
          break;

        case "newline":
          System.out.println();
          break;

        case "isfull":
          System.out.println(q.isFull());
          break;

        case "isempty":
          System.out.println(q.isEmpty());
          break;
        }
      }
    }
  }
}
