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

void all_paths(TreeNode *root, vector<int> &curr_path,
               vector<vector<int>> &paths) {
  if (root == nullptr) {
    return;
  }

  if (root->left == nullptr && root->right == nullptr) {
    curr_path.push_back(root->val);
    paths.emplace_back(curr_path);
    curr_path.pop_back();
  }

  curr_path.push_back(root->val);
  all_paths(root->left, curr_path, paths);
  all_paths(root->right, curr_path, paths);
  curr_path.pop_back();
}

// O(nlogn) / O(n)
vector<vector<int>> all_paths(TreeNode *root) {
  vector<vector<int>> paths;
  vector<int> curr_path;

  all_paths(root, curr_path, paths);

  return paths;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');
  while (tt--) {

    getline(cin, s);

    stringstream ss(s);
    string tmp;
    vector<string> a;

    while (getline(ss, tmp, ' ')) {
      a.push_back(tmp);
    }

    TreeNode *root = build(a);
    auto res = all_paths(root);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }
}