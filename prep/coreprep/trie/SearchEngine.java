import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchEngine {
  static class Trie {
    static class Node {
      Map<Character, Node> children;
      boolean isTerminal;
      int score;

      Node() {
        this.children = new HashMap<>();
        this.isTerminal = false;
        this.score = -1;
      }
    }

    private Node root;

    Trie() { this.root = new Node(); }

    public void insert(String s, int score) { insert(this.root, s, score); }

    void insert(Node node, String s, int score) {
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (node.children.get(c) == null) {
          node.children.put(c, new Node());
          node = node.children.get(c);
        } else {
          node = node.children.get(c);
        }

        if (node.score < score) {
          node.score = score;
        }
      }
      node.isTerminal = true;
      node.score = score;
    }

    public int check(String s) { return check(this.root, s); }

    int check(Node node, String s) {
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (node.children.get(c) == null) {
          return -1;
        }
        node = node.children.get(c);
      }

      return node.score;
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      Trie trie = new Trie();

      for (int i = 0; i < n; i++) {
        String[] input = in.nextLine().trim().split(" ");
        trie.insert(input[0], Integer.parseInt(input[1]));
      }

      for (int i = 0; i < nq; i++) {
        String searchString = in.nextLine();
        System.out.println(trie.check(searchString));
      }
    }
  }
}