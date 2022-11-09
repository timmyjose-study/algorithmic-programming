#include <algorithm>
#include <iostream>
#include <limits>
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

bool has_path(TreeNode *root, int curr_idx, const vector<int> &a) {
  if (root == nullptr) {
    return false;
  }

  if (root->left == nullptr && root->right == nullptr) {
    return curr_idx == a.size() - 1 && a[curr_idx] == root->val;
  }

  return curr_idx < a.size() && root->val == a[curr_idx] &&
         (has_path(root->left, curr_idx + 1, a) ||
          has_path(root->right, curr_idx + 1, a));
}

// O(n) / O(1)
bool has_path(TreeNode *root, const vector<int> &a) {
  return has_path(root, 0, a);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin.ignore(numeric_limits<int>::max(), '\n');
    getline(cin, s);

    stringstream ss(s);
    string tmp;
    vector<string> nodes;

    while (getline(ss, tmp, ' ')) {
      nodes.push_back(tmp);
    }

    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    TreeNode *root = build_tree(nodes);
    cout << (has_path(root, a) ? "true" : "false") << "\n";
  }

  return 0;
}