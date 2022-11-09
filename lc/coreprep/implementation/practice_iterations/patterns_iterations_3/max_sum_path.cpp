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

void max_sum_path(TreeNode *root, int curr_sum, int &max_sum,
                  vector<int> &curr_path, vector<int> &max_path) {
  if (root == nullptr) {
    return;
  }

  curr_path.push_back(root->val);
  curr_sum += root->val;

  if (root->left == nullptr && root->right == nullptr) {
    if (curr_sum > max_sum) {
      max_sum = curr_sum;
      max_path = curr_path;
    }
  } else {
    max_sum_path(root->left, curr_sum, max_sum, curr_path, max_path);
    max_sum_path(root->right, curr_sum, max_sum, curr_path, max_path);
  }

  curr_path.pop_back();
}

// O(nlogn) / O(nlogn)
vector<int> max_sum_path(TreeNode *root) {
  int max_sum = numeric_limits<int>::min();
  vector<int> curr_path;
  vector<int> max_path;

  max_sum_path(root, 0, max_sum, curr_path, max_path);

  return max_path;
}

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
    auto res = max_sum_path(root);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}