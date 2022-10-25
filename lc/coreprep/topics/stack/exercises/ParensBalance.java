import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParensBalance {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNext()) {
        String input = in.nextLine().trim();

        if (input.isEmpty()) {
          break;
        }

        try {
          checkBalanced(input);
          System.out.printf("%s - VALID STRING\n", input);
        } catch (BracketMismatchException ex) {
          System.err.printf("%s - INVALID STRING: %s\n", input,
                            ex.getLocalizedMessage());
        }
      }
    }
  }

  private static void checkBalanced(String input)
      throws BracketMismatchException {
    StringTokenizer tokenizer = new StringTokenizer(input, "(){}[]", true);
    Stack<String> st = new Stack<>();

    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();

      switch (token) {
      case "(":
      case "[":
      case "{":
        st.push(token);
        break;

      case ")":
      case "]":
      case "}":
        if (st.isEmpty()) {
          throw new BracketMismatchException();
        }

        if ((token.equals("(") && !st.peek().equals(")")) ||
            (token.equals("]") && !st.peek().equals("[")) ||
            (token.equals("}") && !st.peek().equals("{"))) {
          throw new BracketMismatchException();
        }

        st.pop();
      }
    }

    if (!st.isEmpty()) {
      throw new BracketMismatchException();
    }
  }
}

class BracketMismatchException extends Exception {
  public BracketMismatchException() {
    super("mismatched parentheses/brackets/braces");
  }
}