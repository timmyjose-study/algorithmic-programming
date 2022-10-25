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

void all_paths_for_sum(TreeNode *root, int sum, vector<int> &curr_path,
                       vector<vector<int>> &all_paths) {
  if (root == nullptr) {
    return;
  }

  curr_path.push_back(root->val);

  if (root->val == sum && root->left == nullptr && root->right == nullptr) {
    all_paths.push_back(curr_path);
  } else {
    all_paths_for_sum(root->left, sum - root->val, curr_path, all_paths);
    all_paths_for_sum(root->right, sum - root->val, curr_path, all_paths);
  }

  curr_path.pop_back();
}

vector<vector<int>> all_paths_for_sum(TreeNode *root, int sum) {
  vector<vector<int>> all_paths;
  vector<int> curr_path;
  all_paths_for_sum(root, sum, curr_path, all_paths);

  return all_paths;
}

// O(nlogn) / O(nlogn)
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
    auto res = all_paths_for_sum(root, sum);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}