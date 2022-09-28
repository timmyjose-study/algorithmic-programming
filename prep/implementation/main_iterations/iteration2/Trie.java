import java.util.*;

public class Trie {
  static class TrieNode {
    boolean isTerminal;
    int score;
    Map<Character, TrieNode> children;

    TrieNode() {
      this.children = new HashMap<>();
      this.score = 0;
    }
  }

  private TrieNode root;

  public Trie() { this.root = new TrieNode(); }

  public void insert(String s, int score) { insert(this.root, s, score); }

  private void insert(TrieNode node, String s, int score) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (node.children.get(c) == null) {
        node.children.put(c, new TrieNode());
      }
      node = node.children.get(c);
      if (node.score < score) {
        node.score = score;
      }
    }

    node.isTerminal = true;
  }

  public int search(String s) { return search(this.root, s); }

  private int search(TrieNode node, String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
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