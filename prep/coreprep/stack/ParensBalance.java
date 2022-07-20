import java.util.Scanner;

public class ParensBalance {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tt = in.nextInt();
      in.nextLine();

      while (tt-- != 0) {
        String input = in.nextLine().trim();
        Stack<Character> st = new Stack<>(100);
        boolean valid = true;

        for (int i = 0; i < input.length(); i++) {
          char c = input.charAt(i);
          if (c == '(' || c == '[' || c == '{') {
            st.push(c);
          } else if (c == ')' || c == ']' || c == '}') {
            if (st.isEmpty()) {
              valid = false;
              break;
            }

            char d = st.pop();
            if ((c == ')' && d != '(') || (c == ']' && d != '[') ||
                (c == '}' && d != '{')) {
              valid = false;
              break;
            }
          }
        }

        if (!valid || !st.isEmpty()) {
          System.out.println("Invalid string");
        } else {
          System.out.println("Valid string");
        }
      }
    }
  }
}