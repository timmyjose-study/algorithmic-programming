import java.util.*;

public class SinglyLinkedList<T> implements MyList<T> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyList<Integer> sll = new SinglyLinkedList<>();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          sll.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          sll.pushBack(elem);
        } break;

        case "popfront":
          System.out.printf("%d ", sll.popFront());
          break;

        case "popback":
          System.out.printf("%d ", sll.popBack());
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          sll.removeElem(elem);
        } break;

        case "print":
          System.out.println(sll);
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypopfront":
          while (!sll.isEmpty()) {
            System.out.printf("%d ", sll.popFront());
          }
          break;

        case "tillemptypopback":
          while (!sll.isEmpty()) {
            System.out.printf("%d ", sll.popBack());
          }
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}