import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPrefix {
  private static final Map<Pair<String, String>, Boolean> precTable;

  static {
    precTable = new HashMap<>();

    precTable.put(new Pair<>("+", "+"), false);
    precTable.put(new Pair<>("+", "-"), false);
    precTable.put(new Pair<>("+", "*"), false);
    precTable.put(new Pair<>("+", "/"), false);
    precTable.put(new Pair<>("+", "$"), false);
    precTable.put(new Pair<>(")", "+"), false);
    precTable.put(new Pair<>("+", ")"), false);

    precTable.put(new Pair<>("-", "+"), false);
    precTable.put(new Pair<>("-", "-"), false);
    precTable.put(new Pair<>("-", "*"), false);
    precTable.put(new Pair<>("-", "/"), false);
    precTable.put(new Pair<>("-", "$"), false);
    precTable.put(new Pair<>(")", "-"), false);
    precTable.put(new Pair<>("-", ")"), false);

    precTable.put(new Pair<>("*", "+"), false);
    precTable.put(new Pair<>("*", "-"), false);
    precTable.put(new Pair<>("*", "*"), true);
    precTable.put(new Pair<>("*", "/"), true);
    precTable.put(new Pair<>("*", "$"), false);
    precTable.put(new Pair<>(")", "*"), false);
    precTable.put(new Pair<>("+", ")"), false);

    precTable.put(new Pair<>("/", "+"), true);
    precTable.put(new Pair<>("/", "-"), true);
    precTable.put(new Pair<>("/", "*"), true);
    precTable.put(new Pair<>("/", "/"), false);
    precTable.put(new Pair<>("/", "$"), false);
    precTable.put(new Pair<>(")", "/"), false);
    precTable.put(new Pair<>("/", ")"), false);

    precTable.put(new Pair<>("$", "+"), true);
    precTable.put(new Pair<>("$", "-"), true);
    precTable.put(new Pair<>("$", "*"), true);
    precTable.put(new Pair<>("$", "/"), true);
    precTable.put(new Pair<>("$", "$"), true);
    precTable.put(new Pair<>(")", "$"), false);
    precTable.put(new Pair<>("+", ")"), false);

    precTable.put(new Pair<>("+", "+"), true);
    precTable.put(new Pair<>("+", "-"), true);
    precTable.put(new Pair<>("+", "*"), false);
    precTable.put(new Pair<>("+", "/"), true);
    precTable.put(new Pair<>("+", "$"), false);
    precTable.put(new Pair<>(")", "$"), false);
    precTable.put(new Pair<>("$", ")"), false);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNext()) {
        String input = in.nextLine().trim();

        try {
          String prefix = infixToPrefix(input);
          System.out.printf("input: %s, prefix: %s\n", input, prefix);
        } catch (ParseException ex) {
          System.err.printf("input: %s, output: ERROR\n", input);
        }
      }
    }
  }

  private static String infixToPrefix(String input) throws ParseException {
    StringBuffer reversed = new StringBuffer();
    for (int i = input.length() - 1; i >= 0; i--) {
      reversed.append(input.charAt(i));
    }

    StringTokenizer tokenizer =
        new StringTokenizer(reversed.toString(), " \t+-*$(){}[]", true);
    Stack<String> opStack = new Stack<>();
    Stack<String> reverser = new Stack<>();
    StringBuffer prefix = new StringBuffer();

    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken().trim();

      if (isOperand(token)) {
        reverser.push(token);
      } else if (token.equals(")")) {
        opStack.push(token);
      } else if (token.equals("(")) {
        while (!opStack.isEmpty() && !opStack.peek().equals(")")) {
          reverser.push(opStack.pop());
        }

        if (opStack.isEmpty()) {
          throw new ParseException();
        }

        opStack.pop();
      } else {
        while (!opStack.isEmpty() && precedence(opStack.peek(), token)) {
          reverser.push(opStack.pop());
        }

        opStack.push(token);
      }
    }

    while (!opStack.isEmpty()) {
      reverser.push(opStack.pop());
    }

    while (!reverser.isEmpty()) {
      prefix.append(reverser.pop());
    }

    return prefix.toString();
  }

  private static boolean isOperand(String token) {
    return switch (token) {
      case "(", "[", "{", ")", "]", "}", "+", "-", "*", "/", "$" -> false;
        default -> true;
    };
  }

  private static boolean precedence(String tos, String token) {
    return InfixToPrefix.precTable.get(new Pair<>(tos, token));
  }
}