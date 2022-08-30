import java.util.*;

@SuppressWarnings("unchecked")
public class DynamicArrayStack<T> implements MyStack<T> {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int nq = in.nextInt();
      in.nextLine();

      MyStack<Integer> st = new DynamicArrayStack<>();
      while (nq-- > 0) {
        String[] cmd = in.nextLine().trim().split(" ");

        switch (cmd[0]) {
        case "push": {
          int elem = Integer.parseInt(cmd[1]);
          st.push(elem);

        } break;

        case "pop":
          System.out.println(st.pop());
          break;

        case "peek":
          System.out.println(st.peek());
          break;

        case "tillemptypop":
          while (!st.isEmpty()) {
            System.out.printf("%d ", st.pop());
          }
          break;

        case "newline":
          System.out.println();
          break;

        default:
          throw new UnsupportedOperationException("invalid operation: " +
                                                  cmd[0]);
        }
      }
    }
  }
}