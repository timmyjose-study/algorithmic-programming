import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPrefix {
  private static final Map<Pair<String, String>, Boolean> opTable;

  static {
    opTable = new HashMap<>();
    opTable.put(new Pair<>("+", "+"), true);
    opTable.put(new Pair<>("+", "-"), true);
    opTable.put(new Pair<>("+", "*"), false);
    opTable.put(new Pair<>("+", "/"), false);
    opTable.put(new Pair<>("+", "$"), false);
    opTable.put(new Pair<>("(", "+"), false);
    opTable.put(new Pair<>("+", "("), false);

    opTable.put(new Pair<>("-", "+"), true);
    opTable.put(new Pair<>("-", "-"), true);
    opTable.put(new Pair<>("-", "*"), false);
    opTable.put(new Pair<>("-", "/"), false);
    opTable.put(new Pair<>("-", "$"), false);
    opTable.put(new Pair<>("-", ")"), false);
    opTable.put(new Pair<>("(", "-"), false);

    opTable.put(new Pair<>("*", "+"), true);
    opTable.put(new Pair<>("*", "-"), true);
    opTable.put(new Pair<>("*", "+"), true);
    opTable.put(new Pair<>("*", "/"), true);
    opTable.put(new Pair<>("*", "$"), false);
    opTable.put(new Pair<>("(", "*"), false);
    opTable.put(new Pair<>("*", "("), false);

    opTable.put(new Pair<>("/", "+"), true);
    opTable.put(new Pair<>("/", "-"), true);
    opTable.put(new Pair<>("/", "*"), true);
    opTable.put(new Pair<>("/", "/"), true);
    opTable.put(new Pair<>("/", "$"), false);
    opTable.put(new Pair<>("(", "/"), false);
    opTable.put(new Pair<>("/", "("), false);

    opTable.put(new Pair<>("$", "+"), true);
    opTable.put(new Pair<>("$", "-"), true);
    opTable.put(new Pair<>("$", "*"), true);
    opTable.put(new Pair<>("$", "/"), true);
    opTable.put(new Pair<>("$", "$"), false);
    opTable.put(new Pair<>("$", ")"), false);
    opTable.put(new Pair<>("(", "$"), false);
  }

  public static void main(String[] args) {
    try (BufferedReader in =
             new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(in.readLine().trim());

      for (int i = 0; i < n; i++) {
        String input = in.readLine().trim();
        try {
          String output = InfixToPrefix.infixToPrefix(input);
          System.out.printf("%s: VALID, postfix: %s\n", input, output);
        } catch (ParseException ex) {
          System.err.printf("%s: ERROR\n", input);
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private static String infixToPrefix(String input) throws ParseException {
    Stack<String> opStack = new Stack<>();
    StringBuffer output = new StringBuffer();

    StringTokenizer tokenizer = new StringTokenizer(input, " \t+-*/$()", true);

    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
      token = token.trim();

      if (token.isEmpty()) {
        continue;
      }

      if (isOperand(token)) {
        output.append(token);
      } else if (token.equals("(")) {
        opStack.push(token);
      } else if (token.equals(")")) {
        while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
          output.append(opStack.pop());
        }

        if (opStack.isEmpty()) {
          throw new ParseException("right paren without matching left paren");
        }

        opStack.pop();
      } else {
        while (!opStack.isEmpty() && precedence(opStack.peek(), token)) {
          output.append(opStack.pop());
        }
        opStack.push(token);
      }
    }

    while (!opStack.isEmpty()) {
      output.append(opStack.pop());
    }

    return output.toString();
  }

  private static boolean isOperand(String token) {
    switch (token) {
    case "(":
    case "+":
    case "-":
    case "*":
    case "/":
    case "$":
    case ")":
      return false;
    default:
      return true;
    }
  }

  private static boolean precedence(String tos, String op) {
    return InfixToPrefix.opTable.get(new Pair(tos, op));
  }
}

class ParseException extends Exception {
  public ParseException(String message) { super(message); }
}

record Pair<T, U>(T first, U second) {}