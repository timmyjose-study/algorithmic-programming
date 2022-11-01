#include <algorithm>
#include <iomanip>
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

// O(n) / O(n)
vector<double> level_averages(TreeNode *root) {
  vector<double> res;

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    int sz = q.size();
    double sum = 0.0;

    for (int i = 0; i < sz; i++) {
      TreeNode *node = q.front();
      q.pop();

      sum += node->val;

      if (node->left) {
        q.push(node->left);
      }

      if (node->right) {
        q.push(node->right);
      }
    }
    res.push_back((sum / (double)sz));
  }

  return res;
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
      a.emplace_back(tmp);
    }

    TreeNode *root = build(a);
    auto res = level_averages(root);
    for (double r : res) {
      cout << fixed << setprecision(1) << r << " ";
    }
    cout << "\n";
  }

  return 0;
}