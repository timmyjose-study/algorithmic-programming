#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

struct TrieNode {
  int score;
  map<char, TrieNode *> children;

  TrieNode() { this->score = 0; }

  ~TrieNode() {
    for (auto pair : children) {
      delete pair.second;
    }
  }
};

class Trie {
private:
  TrieNode *root;

  void insert(TrieNode *node, string word, int score) {
    for (char c : word) {
      if (node->children.find(c) == node->children.end()) {
        node->children[c] = new TrieNode();
      }
      node = node->children[c];
      node->score = max(node->score, score);
    }
  }

  int search(TrieNode *node, string word) {
    for (char c : word) {
      if (node->children.find(c) == node->children.end()) {
        return -1;
      }
      node = node->children[c];
    }

    return node->score;
  }

public:
  Trie() { this->root = new TrieNode(); }
  ~Trie() { delete this->root; }

  void insert(string word, int score) { insert(root, word, score); }

  int search(string word) { return search(root, word); }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq;
  cin >> n >> nq;

  Trie trie;
  string word;
  int score;

  for (int i = 0; i < n; i++) {
    cin >> word >> score;
    trie.insert(word, score);
  }

  while (nq--) {
    cin >> word;
    cout << trie.search(word) << "\n";
  }

  return 0;
}