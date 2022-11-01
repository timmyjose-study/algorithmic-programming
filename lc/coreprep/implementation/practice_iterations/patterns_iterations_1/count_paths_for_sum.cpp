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

void count_paths_with_sum(TreeNode *root, int sum, vector<int> &curr_path,
                          int &cnt) {
  if (root == nullptr) {
    return;
  }

  curr_path.push_back(root->val);

  int curr_sum = 0;
  for (int i = curr_path.size() - 1; i >= 0; i--) {
    curr_sum += curr_path[i];

    if (curr_sum == sum) {
      cnt++;
    }
  }

  count_paths_with_sum(root->left, sum, curr_path, cnt);
  count_paths_with_sum(root->right, sum, curr_path, cnt);
  curr_path.pop_back();
}

// On2) / O(n)
int count_paths_with_sum(TreeNode *root, int sum) {
  vector<int> curr_path;
  int cnt = 0;
  count_paths_with_sum(root, sum, curr_path, cnt);

  return cnt;
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
    cout << count_paths_with_sum(root, sum) << "\n";
  }
}