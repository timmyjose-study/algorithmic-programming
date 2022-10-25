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

bool has_sequence_from_root_to_leaf(TreeNode *root, const vector<int> &a,
                                    int curr_idx) {
  if (root == nullptr) {
    return false;
  }

  if (curr_idx >= a.size() || a[curr_idx] != root->val) {
    return false;
  }

  if (root->left == nullptr && root->right == nullptr &&
      curr_idx == a.size() - 1) {
    return true;
  }

  return has_sequence_from_root_to_leaf(root->left, a, curr_idx + 1) ||
         has_sequence_from_root_to_leaf(root->right, a, curr_idx + 1);
}

bool has_sequence_from_root_to_leaf(TreeNode *root, const vector<int> &a) {
  if (root == nullptr) {
    return a.size() == 0;
  }

  return has_sequence_from_root_to_leaf(root, a, 0);
}

// O(n) / O(n)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
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

    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cin.ignore(numeric_limits<int>::max(), '\n');

    TreeNode *root = build_tree(nodes);
    cout << (has_sequence_from_root_to_leaf(root, a) ? "true" : "false")
         << "\n";
  }

  return 0;
}