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

  TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

TreeNode *build(const vector<string> &a, int curr_idx) {
  if (curr_idx >= a.size() || a[curr_idx] == "null") {
    return nullptr;
  }

  TreeNode *node = new TreeNode(stoi(a[curr_idx]));
  node->left = build(a, 2 * curr_idx + 1);
  node->right = build(a, 2 * curr_idx + 2);

  return node;
}

TreeNode *build(const vector<string> &a) { return build(a, 0); }

// O(n) / O(h)
int level_order_successor(TreeNode *root, int k) {
  TreeNode *prev = nullptr;
  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    TreeNode *node = q.front();
    q.pop();

    if (prev && prev->val == k) {
      return node->val;
    }

    prev = node;

    if (node->left) {
      q.push(node->left);
    }

    if (node->right) {
      q.push(node->right);
    }
  }

  return -1;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, k;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> k;
    cin.ignore(1, '\n');

    getline(cin, s);

    stringstream ss(s);
    string tmp;
    vector<string> a;

    while (getline(ss, tmp, ' ')) {
      a.emplace_back(tmp);
    }

    TreeNode *root = build(a);
    cout << level_order_successor(root, k) << "\n";
  }

  return 0;
}