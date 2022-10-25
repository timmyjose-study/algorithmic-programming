#include <algorithm>
#include <iostream>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode *next;

  TreeNode(int val) : val(val), left(nullptr), right(nullptr), next(nullptr) {}
};

TreeNode *build_tree(const vector<string> &nodes, int curr_idx) {
  if (curr_idx >= nodes.size() || nodes[curr_idx] == "null") {
    return nullptr;
  }

  TreeNode *root = new TreeNode(stoi(nodes[curr_idx]));
  root->left = build_tree(nodes, 2 * curr_idx + 1);
  root->right = build_tree(nodes, 2 * curr_idx + 2);

  return root;
}

TreeNode *build_tree(const vector<string> &nodes) {
  return build_tree(nodes, 0);
}

void connect_level_order_siblings(TreeNode *root) {
  if (root == nullptr) {
    return;
  }

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    int level_size = q.size();
    TreeNode *prev = nullptr;

    for (int i = 0; i < level_size; i++) {
      TreeNode *node = q.front();
      q.pop();

      if (prev != nullptr) {
        prev->next = node;
      }
      prev = node;

      if (node->left != nullptr) {
        q.push(node->left);
      }

      if (node->right != nullptr) {
        q.push(node->right);
      }
    }
  }
}

void print_level_order(TreeNode *root) {
  if (root == nullptr) {
    return;
  }

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    TreeNode *node = q.front();
    q.pop();

    if (node->left != nullptr) {
      q.push(node->left);
    } else if (node->right != nullptr) {
      q.push(node->right);
    }

    while (node != nullptr) {
      cout << node->val << " ";
      node = node->next;
    }
    cout << "\n";
  }
}

// O(n) / O(n)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(1);
  while (tt--) {
    getline(cin, s);

    stringstream ss(s);
    string tmp;
    vector<string> nodes;

    while (getline(ss, tmp, ' ')) {
      nodes.push_back(tmp);
    }

    TreeNode *root = build_tree(nodes);
    connect_level_order_siblings(root);
    print_level_order(root);
  }

  return 0;
}