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

void max_sum_path_from_root_to_leaf(TreeNode *root, int sum, int &max_sum,
                                    vector<int> &curr_path,
                                    vector<int> &max_path) {
  if (root == nullptr) {
    return;
  }

  int curr_sum = sum + root->val;
  curr_path.push_back(root->val);

  if (root->left == nullptr && root->right == nullptr) {
    if (curr_sum > max_sum) {
      max_path = curr_path;
      max_sum = curr_sum;
    }
  } else {
    max_sum_path_from_root_to_leaf(root->left, curr_sum, max_sum, curr_path,
                                   max_path);
    max_sum_path_from_root_to_leaf(root->right, curr_sum, max_sum, curr_path,
                                   max_path);
  }

  curr_path.pop_back();
}

vector<int> max_sum_path_from_root_to_leaf(TreeNode *root) {
  vector<int> max_path;
  vector<int> curr_path;
  int max_sum = numeric_limits<int>::min();
  max_sum_path_from_root_to_leaf(root, 0, max_sum, curr_path, max_path);

  return max_path;
}

// O(nlogn) / O(nlogn)
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
    auto res = max_sum_path_from_root_to_leaf(root);
    for (int e : res) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}