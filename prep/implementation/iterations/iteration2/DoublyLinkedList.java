import java.util.*;

public class DoublyLinkedList<T> implements MyList<T> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyList<Integer> dll = new SinglyLinkedList<>();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          dll.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          dll.pushBack(elem);
        } break;

        case "popfront":
          System.out.printf("%d ", dll.popFront());
          break;

        case "popback":
          System.out.printf("%d ", dll.popBack());
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          dll.removeElem(elem);
        } break;

        case "print":
          System.out.println(dll);
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypopfront":
          while (!dll.isEmpty()) {
            System.out.printf("%d ", dll.popFront());
          }
          break;

        case "tillemptypopback":
          while (!dll.isEmpty()) {
            System.out.printf("%d ", dll.popBack());
          }
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}