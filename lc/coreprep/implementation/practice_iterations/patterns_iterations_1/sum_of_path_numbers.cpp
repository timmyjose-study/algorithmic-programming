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

void sum_of_path_numbers(TreeNode *root, int curr_sum, int &tot_sum) {
  if (root == nullptr) {
    return;
  }

  if (root->left == nullptr && root->right == nullptr) {
    curr_sum = 10 * curr_sum + root->val;
    tot_sum += curr_sum;
  }

  sum_of_path_numbers(root->left, 10 * curr_sum + root->val, tot_sum);
  sum_of_path_numbers(root->right, 10 * curr_sum + root->val, tot_sum);
}

// O(n) / O(1)
int sum_of_path_numbers(TreeNode *root) {
  int tot_sum = 0;
  sum_of_path_numbers(root, 0, tot_sum);

  return tot_sum;
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
    cout << sum_of_path_numbers(root) << "\n";
  }
}