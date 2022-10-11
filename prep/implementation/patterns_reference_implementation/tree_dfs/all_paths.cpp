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

void all_paths_from_root_to_leaf(TreeNode *root, vector<int> &curr_path,
                                 vector<vector<int>> &all_paths) {
  if (root == nullptr) {
    return;
  }

  curr_path.push_back(root->val);

  if (root->left == nullptr && root->right == nullptr) {
    all_paths.push_back(curr_path);
  } else {
    all_paths_from_root_to_leaf(root->left, curr_path, all_paths);
    all_paths_from_root_to_leaf(root->right, curr_path, all_paths);
  }

  curr_path.pop_back();
}

vector<vector<int>> all_paths_from_root_to_leaf(TreeNode *root) {
  vector<vector<int>> all_paths;
  vector<int> curr_path;
  all_paths_from_root_to_leaf(root, curr_path, all_paths);

  return all_paths;
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
    auto res = all_paths_from_root_to_leaf(root);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}