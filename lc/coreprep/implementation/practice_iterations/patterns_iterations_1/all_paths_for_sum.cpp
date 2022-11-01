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

TreeNode *build(const vector<string> &a, int curr_idx) {
  if (curr_idx >= a.size() || a[curr_idx] == "null") {
    return nullptr;
  }

  TreeNode *node = new TreeNode(stoi(a[curr_idx]));
  node->left = build(a, 2 * curr_idx + 1);
  node->right = build(a, 2 * curr_idx + 2);

  return node;
}

TreeNode *build(const vector<string> &a) { return build(a, 0); }

void all_paths_with_sum(TreeNode *root, int curr_sum, int sum,
                        vector<int> &curr_path,
                        vector<vector<int>> &all_paths) {
  if (root == nullptr) {
    return;
  }

  if (root->left == nullptr && root->right == nullptr) {
    if (curr_sum + root->val == sum) {
      curr_path.push_back(root->val);
      all_paths.emplace_back(curr_path);
      curr_path.pop_back();
    }
  }

  curr_path.push_back(root->val);

  all_paths_with_sum(root->left, curr_sum + root->val, sum, curr_path,
                     all_paths);
  all_paths_with_sum(root->right, curr_sum + root->val, sum, curr_path,
                     all_paths);

  curr_path.pop_back();
}

// O(nlogn) / O(n)
vector<vector<int>> all_paths_with_sum(TreeNode *root, int sum) {
  vector<vector<int>> all_paths;
  vector<int> curr_path;

  all_paths_with_sum(root, 0, sum, curr_path, all_paths);

  return all_paths;
}

int main() {
  ios::sync_with_stdio(0);
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
    vector<string> a;

    while (getline(ss, tmp, ' ')) {
      a.push_back(tmp);
    }

    TreeNode *root = build(a);
    auto res = all_paths_with_sum(root, sum);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}