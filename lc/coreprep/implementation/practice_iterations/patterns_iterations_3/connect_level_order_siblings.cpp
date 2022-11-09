#include <algorithm>
#include <iostream>
#include <limits>
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

TreeNode *build_tree(int curr_idx, const vector<string> &nodes) {
  if (curr_idx >= nodes.size() || nodes[curr_idx] == "null") {
    return nullptr;
  }

  TreeNode *node = new TreeNode(stoi(nodes[curr_idx]));
  node->left = build_tree(2 * curr_idx + 1, nodes);
  node->right = build_tree(2 * curr_idx + 2, nodes);

  return node;
}

TreeNode *build_tree(const vector<string> &nodes) {
  return build_tree(0, nodes);
}

// O(n) / O(n)
void connect_level_order_siblings(TreeNode *root) {
  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    int sz = q.size();

    TreeNode *prev = q.front();
    q.pop();

    if (prev->left) {
      q.push(prev->left);
    }

    if (prev->right) {
      q.push(prev->right);
    }

    for (int i = 0; i < sz - 1; i++) {
      TreeNode *curr = q.front();
      q.pop();

      prev->next = curr;

      if (curr->left) {
        q.push(curr->left);
      }

      if (curr->right) {
        q.push(curr->right);
      }
      prev = curr;
    }
  }

  q.push(root);
  while (!q.empty()) {
    TreeNode *node = q.front();
    q.pop();

    if (node->left) {
      q.push(node->left);
    } else if (node->right) {
      q.push(node->right);
    }

    TreeNode *curr = node;
    while (curr != nullptr) {
      cout << curr->val << " ";
      curr = curr->next;
    }
    cout << "\n";
  }
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');

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
  }

  return 0;
}