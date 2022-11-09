#include <algorithm>
#include <iostream>
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

int sum_of_all_paths(TreeNode *root, int sum) {
  if (root == nullptr) {
    return 0;
  }

  if (root->left == nullptr && root->right == nullptr) {
    return 10 * sum + root->val;
  }

  return sum_of_all_paths(root->left, 10 * sum + root->val) +
         sum_of_all_paths(root->right, 10 * sum + root->val);
}

// O(n) / O(n)
int sum_of_all_paths(TreeNode *root) { return sum_of_all_paths(root, 0); }

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
    cout << sum_of_all_paths(root) << "\n";
  }

  return 0;
}