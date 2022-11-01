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

bool xhas_path_with_sum(TreeNode *root, int curr_sum, int sum) {
  if (root == nullptr) {
    return false;
  }

  if (root->left == nullptr && root->right == nullptr) {
    return curr_sum + root->val == sum;
  }

  return xhas_path_with_sum(root->left, curr_sum + root->val, sum) ||
         xhas_path_with_sum(root->right, curr_sum + root->val, sum);
}

// O(n) / O(n)
bool xhas_path_with_sum(TreeNode *root, int sum) {
  if (root == nullptr) {
    return false;
  }

  return xhas_path_with_sum(root, 0, sum);
}

// O(n) / O(n)
bool has_path_with_sum(TreeNode *root, int sum) {
  if (root == nullptr) {
    return false;
  }

  vector<pair<TreeNode *, int>> st;
  st.push_back(make_pair<>(root, 0));

  while (!st.empty()) {
    pair<TreeNode *, int> pair = st.back();
    st.pop_back();

    if (pair.first == nullptr) {
      continue;
    }

    if (pair.first->left == nullptr && pair.first->right == nullptr) {
      if (pair.second + pair.first->val == sum) {
        return true;
      }
    }

    if (pair.first->right) {
      st.push_back(
          make_pair<>(pair.first->right, pair.second + pair.first->val));
    }

    if (pair.first->left) {
      st.push_back(
          make_pair<>(pair.first->left, pair.second + pair.first->val));
    }
  }

  return false;
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
    cout << (has_path_with_sum(root, sum) ? "true" : "false") << "\n";
  }

  return 0;
}