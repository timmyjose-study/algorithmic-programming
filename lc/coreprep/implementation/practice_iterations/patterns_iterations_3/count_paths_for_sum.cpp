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

TreeNode *build_tree(int curr_idx, const vector<string> &nodes) {
  if (curr_idx >= nodes.size() || nodes[curr_idx] == "null") {
    return nullptr;
  }

  TreeNode *node = new TreeNode(stoi(nodes[curr_idx]));
  node->left = build_tree(2 * curr_idx + 1, nodes);
  node->right = build_tree(2 * curr_idx + 2, nodes);

  return node;
}

TreeNode *build_tree(const vector<string> &nodes) {
  return build_tree(0, nodes);
}

void count_paths_for_sum(TreeNode *root, int sum, vector<int> &curr_path,
                         int &tot_paths) {
  if (root == nullptr) {
    return;
  }

  curr_path.push_back(root->val);

  int curr_sum = 0;
  for (int i = curr_path.size() - 1; i >= 0; i--) {
    curr_sum += curr_path[i];

    if (curr_sum == sum) {
      tot_paths++;
    }
  }

  count_paths_for_sum(root->left, sum, curr_path, tot_paths);
  count_paths_for_sum(root->right, sum, curr_path, tot_paths);
  curr_path.pop_back();
}

// O(n2) / O(n)
int count_paths_for_sum(TreeNode *root, int sum) {
  vector<int> curr_path;
  int tot_paths = 0;

  count_paths_for_sum(root, sum, curr_path, tot_paths);

  return tot_paths;
}

int main() {
  ios_base::sync_with_stdio(0);
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
    vector<string> nodes;

    while (getline(ss, tmp, ' ')) {
      nodes.push_back(tmp);
    }

    TreeNode *root = build_tree(nodes);
    cout << count_paths_for_sum(root, sum) << "\n";
  }

  return 0;
}