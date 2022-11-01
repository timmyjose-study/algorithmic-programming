#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
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
vector<vector<int>> zigzag_traversal(TreeNode *root) {
  vector<vector<int>> res;
  bool l2r = true;

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    vector<int> curr;
    int sz = q.size();

    for (int i = 0; i < sz; i++) {
      TreeNode *node = q.front();
      q.pop();

      curr.push_back(node->val);

      if (node->left) {
        q.push(node->left);
      }

      if (node->right) {
        q.push(node->right);
      }
    }

    if (l2r) {
      res.emplace_back(curr);
      l2r = false;
    } else {
      vector<int> rev(curr.rbegin(), curr.rend());
      res.emplace_back(rev);
      l2r = true;
    }
  }

  return res;
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

    stringstream inp(s);
    string tmp;
    vector<string> a;

    while (getline(inp, tmp, ' ')) {
      a.push_back(tmp);
    }

    TreeNode *root = build(a);
    auto res = zigzag_traversal(root);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}