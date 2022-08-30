import java.util.*;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements MyList<T> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyList<Integer> dynArr = new DynamicArray<>();

      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "pushfront": {
          int elem = Integer.parseInt(cmd[1]);
          dynArr.pushFront(elem);
        } break;

        case "pushback": {
          int elem = Integer.parseInt(cmd[1]);
          dynArr.pushBack(elem);
        } break;

        case "popfront":
          System.out.printf("%d ", dynArr.popFront());
          break;

        case "popback":
          System.out.printf("%d ", dynArr.popBack());
          break;

        case "removeelem": {
          int elem = Integer.parseInt(cmd[1]);
          dynArr.removeElem(elem);
        } break;

        case "print":
          System.out.println(dynArr);
          break;

        case "newline":
          System.out.println();
          break;

        case "tillemptypopfront":
          while (!dynArr.isEmpty()) {
            System.out.printf("%d ", dynArr.popFront());
          }
          break;

        case "tillemptypopback":
          while (!dynArr.isEmpty()) {
            System.out.printf("%d ", dynArr.popBack());
          }
          break;

        default:
          throw new UnsupportedOperationException("invalid command: " + cmd[0]);
        }
      }
    }
  }
}