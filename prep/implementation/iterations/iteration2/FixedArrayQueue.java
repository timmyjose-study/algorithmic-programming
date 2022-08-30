import java.util.*;

@SuppressWarnings("unchecked")
public class FixedArrayQueue<T> implements MyQueue<T> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int size = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      MyQueue<Integer> q = new FixedArrayQueue<>(size);

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "enqueue": {
          int elem = Integer.parseInt(cmd[1]);
          q.enqueue(elem);
        } break;

        case "dequeue":
          System.out.println(q.dequeue());
          break;

        case "tillemptydequeue":
          while (!q.isEmpty()) {
            System.out.printf("%d ", q.dequeue());
          }
          break;

        case "newline":
          System.out.println("\n");
          break;

        case "isfull":
          System.out.println(q.isFull());
          break;

        case "isempty":
          System.out.println(q.isEmpty());
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}