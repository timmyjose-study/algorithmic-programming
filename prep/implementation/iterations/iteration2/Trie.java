import java.util.*;

public class Trie {
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