#include <algorithm>
#include <functional>
#include <iostream>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

template <typename T> struct Node {
  T data;
  Node(T data) { this->data = data; }
};

template <typename T> class BinaryTree {
private:
  vector<Node<T> *> arr;

  void build(int node, const vector<string> &nodes,
             function<T(string)> parser) {
    if (node >= nodes.size() || nodes[node] == "null") {
      arr[node] = nullptr;
      return;
    }

    if (arr[node] == nullptr) {
      arr[node] = new Node(parser(nodes[node]));
    }

    if (2 * node + 1 < nodes.size()) {
      build(2 * node + 1, nodes, parser);
    }

    if (2 * node + 2 < nodes.size()) {
      build(2 * node + 2, nodes, parser);
    }
  }

  int height(int node) {
    if (arr[node] == nullptr) {
      return 0;
    }

    return 1 + max(height(2 * node + 1), height(2 * node + 2));
  }

public:
  BinaryTree(const vector<string> &nodes, function<T(string)> parser) {
    for (int i = 0; i < nodes.size(); i++) {
      this->arr.push_back(nullptr);
    }

    build(0, nodes, parser);
  }

  ~BinaryTree() {
    for (auto node_ptr : this->arr) {
      if (!node_ptr) {
        // delete node_ptr;
      }
    }
  }

  void dfs_pre(int node) {
    if (arr[node] == nullptr) {
      return;
    }

    cout << arr[node]->data << " ";

    if (2 * node + 1 < arr.size()) {
      dfs_pre(2 * node + 1);
    }

    if (2 * node + 2 < arr.size()) {
      dfs_pre(2 * node + 2);
    }
  }

  void dfs_pre() {
    dfs_pre(0);
    cout << "\n";
  }

  void dfs_pre_iter() {
    if (arr[0] == nullptr) {
      return;
    }

    vector<int> st;
    st.push_back(0);

    while (!st.empty()) {
      int node = st.back();
      st.pop_back();

      cout << arr[node]->data << " ";

      if (2 * node + 2 < arr.size() && arr[2 * node + 2] != nullptr) {
        st.push_back(2 * node + 2);
      }

      if (2 * node + 1 < arr.size() && arr[2 * node + 1] != nullptr) {
        st.push_back(2 * node + 1);
      }
    }
    cout << "\n";
  }

  void dfs_in(int node) {
    if (arr[node] == nullptr) {
      return;
    }

    if (2 * node + 1 < arr.size() && arr[2 * node + 1] != nullptr) {
      dfs_in(2 * node + 1);
    }

    cout << arr[node]->data << " ";

    if (2 * node + 2 < arr.size() && arr[2 * node + 2] != nullptr) {
      dfs_in(2 * node + 2);
    }
  }

  void dfs_in() {
    dfs_in(0);
    cout << "\n";
  }

  void dfs_in_iter() {
    vector<int> st;
    int curr_node = 0;

    while ((curr_node < arr.size() && arr[curr_node] != nullptr) ||
           !st.empty()) {
      while (curr_node < arr.size() && arr[curr_node] != nullptr) {
        st.push_back(curr_node);
        curr_node = 2 * curr_node + 1;
      }

      if (!st.empty()) {
        curr_node = st.back();
        st.pop_back();
        cout << arr[curr_node]->data << " ";
        curr_node = 2 * curr_node + 2;
      }
    }
    cout << "\n";
  }

  void dfs_post(int node) {
    if (arr[node] == nullptr) {
      return;
    }

    if (2 * node + 1 < arr.size()) {
      dfs_post(2 * node + 1);
    }

    if (2 * node + 2 < arr.size()) {
      dfs_post(2 * node + 2);
    }

    cout << arr[node]->data << " ";
  }

  void dfs_post() {
    dfs_post(0);
    cout << "\n";
  }

  void dfs_post_iter() {
    vector<int> st;
    vector<int> rev_st;

    st.push_back(0);
    while (!st.empty()) {
      int node = st.back();
      st.pop_back();

      rev_st.push_back(node);

      if (2 * node + 1 < arr.size() && arr[2 * node + 1] != nullptr) {
        st.push_back(2 * node + 1);
      }

      if (2 * node + 2 < arr.size() && arr[2 * node + 2] != nullptr) {
        st.push_back(2 * node + 2);
      }
    }

    while (!rev_st.empty()) {
      cout << arr[rev_st.back()]->data << " ";
      rev_st.pop_back();
    }
    cout << "\n";
  }

  void bfs() {
    queue<int> q;
    q.push(0);

    while (!q.empty()) {
      int node = q.front();
      q.pop();

      cout << arr[node]->data << " ";

      if (2 * node + 1 < arr.size() && arr[2 * node + 1] != nullptr) {
        q.push(2 * node + 1);
      }

      if (2 * node + 2 < arr.size() && arr[2 * node + 2] != nullptr) {
        q.push(2 * node + 2);
      }
    }
    cout << "\n";
  }

  int height() { return height(0); }

  void bfs_rec(int node, int level) {
    if (arr[node] == nullptr) {
      return;
    }

    if (level == 0) {
      cout << arr[node]->data << " ";
    } else {
      if (2 * node + 1 < arr.size()) {
        bfs_rec(2 * node + 1, level - 1);
      }

      if (2 * node + 2 < arr.size()) {
        bfs_rec(2 * node + 2, level - 1);
      }
    }
  }

  void bfs_rec() {
    int h = height();
    for (int i = 0; i < h; i++) {
      bfs_rec(0, i);
    }
    cout << "\n";
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string input;
  getline(cin, input);

  stringstream ss(input);
  vector<string> nodes;
  string tmp;

  while (getline(ss, tmp, ' ')) {
    nodes.push_back(tmp);
  }

  BinaryTree<int> tree(nodes, [](const string &s) { return stoi(s); });

  tree.dfs_pre();
  tree.dfs_pre_iter();

  tree.dfs_in();
  tree.dfs_in_iter();

  tree.dfs_post();
  tree.dfs_post_iter();

  tree.bfs();
  tree.bfs_rec();

  return 0;
}