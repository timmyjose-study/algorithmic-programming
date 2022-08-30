import java.util.*;

public class Trie {
  static class Node {
    boolean isTerminal;
    int score;
    Map<Character, Node> children;

    Node() { this.children = new HashMap<>(); }
  }

  private Node root;

  public Trie() { this.root = new Node(); }

  public void insert(String word, int score) { insert(this.root, word, score); }

  private void insert(Node node, String word, int score) {
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children.get(c) == null) {
        node.children.put(c, new Node());
      }
      node = node.children.get(c);
      if (node.score < score) {
        node.score = score;
      }
    }

    node.isTerminal = true;
  }

  public int search(String word) { return search(this.root, word); }

  private int search(Node node, String word) {
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children.get(c) == null) {
        return -1;
      }
      node = node.children.get(c);
    }

    return node.score;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int nq = in.nextInt();
      in.nextLine();

      Trie trie = new Trie();
      for (int i = 0; i < n; i++) {
        String[] inp = in.nextLine().trim().split(" ");
        trie.insert(inp[0], Integer.parseInt(inp[1]));
      }

      while (nq-- > 0) {
        String word = in.nextLine().trim();
        System.out.println(trie.search(word));
      }
    }
  }
}