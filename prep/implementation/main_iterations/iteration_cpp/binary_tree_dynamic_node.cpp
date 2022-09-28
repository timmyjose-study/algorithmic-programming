#include <algorithm>
#include <functional>
#include <iostream>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

template <typename T> struct TreeNode {
  T data;
  TreeNode *left;
  TreeNode *right;

  TreeNode(T data) {
    this->data = data;
    this->left = this->right = nullptr;
  }

  ~TreeNode() {
    if (this->left) {
      delete this->left;
    }

    if (this->right) {
      delete this->right;
    }
  }
};

template <typename T> class BinaryTree {
private:
  TreeNode<T> *root;

  TreeNode<T> *build(TreeNode<T> *node, int curr_idx,
                     const vector<string> &nodes, function<T(string)> parser) {
    if (curr_idx >= nodes.size() || nodes[curr_idx] == "null") {
      return nullptr;
    }

    if (node == nullptr) {
      node = new TreeNode(parser(nodes[curr_idx]));
    }

    node->left = build(node->left, 2 * curr_idx + 1, nodes, parser);
    node->right = build(node->right, 2 * curr_idx + 2, nodes, parser);

    return node;
  }

public:
  BinaryTree(const vector<string> &nodes, function<T(string)> parser) {
    this->root = nullptr;
    this->root = build(this->root, 0, nodes, parser);
  }

  ~BinaryTree() { delete this->root; }

  void dfs_pre(TreeNode<T> *node) {
    if (node == nullptr) {
      return;
    }

    cout << node->data << " ";
    dfs_pre(node->left);
    dfs_pre(node->right);
  }

  void dfs_pre() {
    dfs_pre(this->root);
    cout << "\n";
  }

  void dfs_pre_iter() {
    vector<TreeNode<T> *> st;
    st.push_back(this->root);

    while (!st.empty()) {
      TreeNode<T> *node = st.back();
      st.pop_back();
      cout << node->data << " ";

      if (node->right != nullptr) {
        st.push_back(node->right);
      }

      if (node->left != nullptr) {
        st.push_back(node->left);
      }
    }
    cout << "\n";
  }

  void dfs_in(TreeNode<T> *node) {
    if (node == nullptr) {
      return;
    }

    dfs_in(node->left);
    cout << node->data << " ";
    dfs_in(node->right);
  }

  void dfs_in() {
    dfs_in(this->root);
    cout << "\n";
  }

  void dfs_in_iter() {
    vector<TreeNode<T> *> st;
    TreeNode<T> *curr_node = this->root;

    while (curr_node != nullptr || !st.empty()) {
      while (curr_node != nullptr) {
        st.push_back(curr_node);
        curr_node = curr_node->left;
      }

      if (!st.empty()) {
        curr_node = st.back();
        st.pop_back();
        cout << curr_node->data << " ";
        curr_node = curr_node->right;
      }
    }
    cout << "\n";
  }

  void dfs_post(TreeNode<T> *node) {
    if (node == nullptr) {
      return;
    }

    dfs_post(node->left);
    dfs_post(node->right);
    cout << node->data << " ";
  }

  void dfs_post() {
    dfs_post(this->root);
    cout << "\n";
  }

  void dfs_post_iter() {
    vector<TreeNode<T> *> st;
    vector<TreeNode<T> *> rev_st;

    st.push_back(this->root);
    while (!st.empty()) {
      TreeNode<T> *node = st.back();
      st.pop_back();

      rev_st.push_back(node);

      if (node->left != nullptr) {
        st.push_back(node->left);
      }

      if (node->right != nullptr) {
        st.push_back(node->right);
      }
    }

    while (!rev_st.empty()) {
      cout << rev_st.back()->data << " ";
      rev_st.pop_back();
    }
    cout << "\n";
  }

  void bfs() {
    queue<TreeNode<T> *> q;
    q.push(this->root);

    while (!q.empty()) {
      TreeNode<T> *node = q.front();
      q.pop();

      cout << node->data << " ";

      if (node->left != nullptr) {
        q.push(node->left);
      }

      if (node->right != nullptr) {
        q.push(node->right);
      }
    }
    cout << "\n";
  }

  int height(TreeNode<T> *node) {
    if (node == nullptr) {
      return 0;
    }

    return 1 + max(height(node->left), height(node->right));
  }

  int height() { return height(this->root); }

  void bfs_rec(TreeNode<T> *node, int level) {
    if (node == nullptr) {
      return;
    }

    if (level == 0) {
      cout << node->data << " ";
    } else {
      bfs_rec(node->left, level - 1);
      bfs_rec(node->right, level - 1);
    }
  }

  void bfs_rec() {
    int h = height();
    for (int i = 0; i < h; i++) {
      bfs_rec(this->root, i);
    }
    cout << "\n";
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string inp;
  getline(cin, inp);

  string tmp;
  stringstream ss(inp);
  vector<string> nodes;

  while (getline(ss, tmp, ' ')) {
    nodes.push_back(tmp);
  }

  BinaryTree<int> tree(nodes, [](const string &inp) { return stoi(inp); });

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