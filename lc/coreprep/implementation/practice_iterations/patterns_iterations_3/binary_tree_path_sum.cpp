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
bool has_path(TreeNode *root, int sum) {
  if (root == nullptr) {
    return false;
  }

  if (root->left == nullptr && root->right == nullptr && root->val == sum) {
    return true;
  }

  return has_path(root->left, sum - root->val) ||
         has_path(root->right, sum - root->val);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, sum;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> sum;
    cin.ignore(1, '\n');

    getline(cin, s);

    stringstream ss(s);
    string tmp;
    vector<string> nodes;

    while (getline(ss, tmp, ' ')) {
      nodes.push_back(tmp);
    }

    TreeNode *root = build_tree(nodes);
    cout << (has_path(root, sum) ? "true" : "false") << "\n";
  }

  return 0;
}