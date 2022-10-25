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

void count_paths_for_sum(TreeNode *root, int sum, vector<int> &curr_path,
                         vector<vector<int>> &paths) {
  if (root == nullptr) {
    return;
  }

  curr_path.push_back(root->val);

  int path_sum = 0;
  for (int i = curr_path.size() - 1; i >= 0; i--) {
    path_sum += curr_path[i];

    if (path_sum == sum) {
      vector<int> v(curr_path.begin() + i, curr_path.end());
      paths.emplace_back(v);
    }
  }

  count_paths_for_sum(root->left, sum, curr_path, paths);
  count_paths_for_sum(root->right, sum, curr_path, paths);

  curr_path.pop_back();
}

vector<vector<int>> count_paths_for_sum(TreeNode *root, int sum) {
  vector<vector<int>> paths;
  vector<int> curr_path;
  count_paths_for_sum(root, sum, curr_path, paths);

  return paths;
}

// O(n3) / O(n)
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
    auto res = count_paths_for_sum(root, sum);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}