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

// O(n) / O(n)
int minimum_depth(TreeNode *root) {
  int min_depth = 0;

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    min_depth++;

    int sz = q.size();
    bool min_depth_found = false;
    for (int i = 0; i < sz; i++) {
      TreeNode *node = q.front();
      q.pop();

      if (node->left == nullptr && node->right == nullptr) {
        min_depth_found = true;
        break;
      }

      if (node->left) {
        q.push(node->left);
      }

      if (node->right) {
        q.push(node->right);
      }
    }

    if (min_depth_found) {
      break;
    }
  }

  return min_depth;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');

  while (tt--) {
    getline(cin, s);

    stringstream ss(s);
    string tmp;
    vector<string> a;

    while (getline(ss, tmp, ' ')) {
      a.emplace_back(tmp);
    }

    TreeNode *root = build(a);
    cout << minimum_depth(root) << "\n";
  }

  return 0;
}