#include <algorithm>
#include <iostream>
#include <limits>
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

void max_sum_path(TreeNode *root, int curr_sum, int &max_sum,
                  vector<int> &curr_path, vector<int> &path) {
  if (root == nullptr) {
    return;
  }

  if (root->left == nullptr && root->right == nullptr) {
    curr_sum += root->val;

    if (curr_sum > max_sum) {
      curr_path.push_back(root->val);
      path = curr_path;
      curr_path.pop_back();
      max_sum = curr_sum;
      curr_sum -= root->val;
    }
  }

  max_sum = max(max_sum, curr_sum + root->val);

  curr_path.push_back(root->val);
  max_sum_path(root->left, curr_sum + root->val, max_sum, curr_path, path);
  max_sum_path(root->right, curr_sum + root->val, max_sum, curr_path, path);
  curr_path.pop_back();
}

// O(nlogn) / O(n)
vector<int> max_sum_path(TreeNode *root) {
  vector<int> path;
  vector<int> curr_path;
  int max_sum = numeric_limits<int>::min();

  max_sum_path(root, 0, max_sum, curr_path, path);

  return path;
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
    auto res = max_sum_path(root);
    for (int e : res) {
      cout << e << " ";
    }
    cout << "\n";
  }
}