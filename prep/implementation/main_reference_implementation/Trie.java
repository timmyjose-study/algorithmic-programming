import java.util.*;

public class Trie {
  static class Node {
    int score;
    boolean isTerminal;
    Map<Character, Node> children;

    Node() {
      this.score = 0;
      this.isTerminal = false;
      this.children = new HashMap<>();
    }
  }

  private Node root;

  public Trie() { this.root = new Node(); }

  // O(|S|)
  public void insert(String str, int score) { insert(this.root, str, score); }

  private void insert(Node node, String str, int score) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
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

  // O(|S|)
  public int check(String str) { return check(this.root, str); }

  private int check(Node node, String str) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
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
        String str = in.next().trim();
        int score = in.nextInt();
        trie.insert(str, score);
      }
      in.nextLine();

      while (nq-- > 0) {
        String qs = in.nextLine().trim();
        System.out.println(trie.check(qs));
      }
    }
  }
}