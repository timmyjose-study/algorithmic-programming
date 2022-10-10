#include <algorithm>
#include <deque>
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

  TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
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

vector<vector<int>> reverse_level_order_traversal(TreeNode *root) {
  vector<vector<int>> res;

  if (root == nullptr) {
    return res;
  }

  deque<vector<int>> dq;

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    int level_size = q.size();

    vector<int> level_nodes;
    for (int i = 0; i < level_size; i++) {
      TreeNode *node = q.front();
      q.pop();

      level_nodes.push_back(node->val);

      if (node->left != nullptr) {
        q.push(node->left);
      }

      if (node->right != nullptr) {
        q.push(node->right);
      }
    }

    dq.push_front(level_nodes);
  }

  while (!dq.empty()) {
    res.push_back(dq.front());
    dq.pop_front();
  }

  return res;
}

TreeNode *build_tree(const vector<string> &nodes) {
  return build_tree(nodes, 0);
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

    string tmp;
    stringstream ss(s);
    vector<string> nodes;

    while (getline(ss, tmp, ' ')) {
      nodes.push_back(tmp);
    }

    TreeNode *root = build_tree(nodes);
    auto res = reverse_level_order_traversal(root);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}