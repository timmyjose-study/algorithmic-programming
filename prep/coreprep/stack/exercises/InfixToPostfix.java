import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class InfixToPostfix {
  private static final Map<Pair<String, String>, Boolean> precTable;

  static {
    precTable = new HashMap<>();

    precTable.put(new Pair("+", "+"), true);
    precTable.put(new Pair("+", "-"), true);
    precTable.put(new Pair("+", "*"), false);
    precTable.put(new Pair("+", "/"), false);
    precTable.put(new Pair("+", "$"), false);
    precTable.put(new Pair("(", "+"), false);
    precTable.put(new Pair("+", "("), false);

    precTable.put(new Pair("-", "+"), true);
    precTable.put(new Pair("-", "-"), true);
    precTable.put(new Pair("-", "*"), false);
    precTable.put(new Pair("-", "/"), false);
    precTable.put(new Pair("-", "$"), false);
    precTable.put(new Pair("(", "-"), false);
    precTable.put(new Pair("-", "("), false);

    precTable.put(new Pair("*", "+"), true);
    precTable.put(new Pair("*", "-"), true);
    precTable.put(new Pair("*", "*"), true);
    precTable.put(new Pair("*", "/"), true);
    precTable.put(new Pair("*", "$"), false);
    precTable.put(new Pair("(", "*"), false);
    precTable.put(new Pair("*", "("), false);

    precTable.put(new Pair("/", "+"), true);
    precTable.put(new Pair("/", "-"), true);
    precTable.put(new Pair("/", "*"), true);
    precTable.put(new Pair("/", "/"), true);
    precTable.put(new Pair("/", "$"), false);
    precTable.put(new Pair("(", "/"), false);
    precTable.put(new Pair("/", "("), false);

    precTable.put(new Pair("$", "+"), true);
    precTable.put(new Pair("$", "-"), true);
    precTable.put(new Pair("$", "*"), true);
    precTable.put(new Pair("$", "/"), true);
    precTable.put(new Pair("$", "$"), false);
    precTable.put(new Pair("(", "$"), false);
    precTable.put(new Pair("$", "("), false);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNext()) {
        String input = in.nextLine().trim();
        try {
          String postfix = infixToPostfix(input);
          System.out.printf("input: %s, output: %s\n", input, postfix);
        } catch (ParseException ex) {
          System.out.printf("Invalid input: %s\n", input);
        }
      }
    }
  }

  private static String infixToPostfix(String input) throws ParseException {
    StringTokenizer tokenizer =
        new StringTokenizer(input, "[ \t+-*/$()]", true);
    Stack<String> opStack = new Stack<>();
    StringBuffer postfix = new StringBuffer();

    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken().trim();

      if (isOperand(token)) {
        postfix.append(token);
      } else if (token.equals("(")) {
        opStack.push(token);
      } else if (token.equals(")")) {
        while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
          postfix.append(opStack.pop());
        }

        if (opStack.isEmpty()) {
          throw new ParseException();
        }

        opStack.pop();
      } else {
        while (!opStack.isEmpty() && precedence(opStack.peek(), token)) {
          postfix.append(opStack.pop());
        }

        opStack.push(token);
      }
    }

    while (!opStack.isEmpty()) {
      postfix.append(opStack.pop());
    }

    return postfix.toString();
  }

  private static boolean isOperand(String token) {
    return switch (token) {
        case "+", "-", "*", "/", "$", "(", ")" -> false;
          default -> true;
    };
  }

  private static boolean precedence(String stackTop, String token) {
    return InfixToPostfix.precTable.get(new Pair(stackTop, token));
  }
}

class Pair<T, U> {
  T first;
  U second;

  public Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Pair p) {
      return this.first.equals(p.first) && this.second.equals( p.second);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.first, this.second);
  }
}

class ParseException extends Exception {}