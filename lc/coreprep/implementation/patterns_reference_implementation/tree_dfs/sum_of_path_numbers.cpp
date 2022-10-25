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

int sum_of_path_numbers(TreeNode *root, int sum) {
  if (root == nullptr) {
    return 0;
  }

  int curr_sum = 10 * sum + root->val;

  if (root->left == nullptr && root->right == nullptr) {
    return curr_sum;
  }

  return sum_of_path_numbers(root->left, curr_sum) +
         sum_of_path_numbers(root->right, curr_sum);
}

int sum_of_path_numbers(TreeNode *root) { return sum_of_path_numbers(root, 0); }

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
    cout << sum_of_path_numbers(root) << "\n";
  }

  return 0;
}