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

int count_paths_for_sum(TreeNode *root, int sum, vector<int> &curr_path) {
  if (root == nullptr) {
    return 0;
  }

  curr_path.push_back(root->val);

  int path_sum = 0, path_count = 0;
  for (int i = curr_path.size() - 1; i >= 0; i--) {
    path_sum += curr_path[i];

    if (path_sum == sum) {
      path_count++;
    }
  }

  path_count += count_paths_for_sum(root->left, sum, curr_path);
  path_count += count_paths_for_sum(root->right, sum, curr_path);

  curr_path.pop_back();

  return path_count;
}

int count_paths_for_sum(TreeNode *root, int sum) {
  vector<int> curr_path;
  return count_paths_for_sum(root, sum, curr_path);
}

// O(n2) / O(n)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, sum;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> sum;
    cin.ignore(1);

    getline(cin, s);

    string tmp;
    stringstream ss(s);
    vector<string> nodes;

    while (getline(ss, tmp, ' ')) {
      nodes.push_back(tmp);
    }

    TreeNode *root = build_tree(nodes);
    cout << count_paths_for_sum(root, sum) << "\n";
  }

  return 0;
}