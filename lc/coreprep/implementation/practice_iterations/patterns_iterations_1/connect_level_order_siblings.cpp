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
  TreeNode *next;

  TreeNode(int val) : val(val), left(nullptr), right(nullptr), next(nullptr) {}
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

void set_up_next_pointers(TreeNode *root) {
  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    int sz = q.size();

    vector<TreeNode *> level_nodes;
    for (int i = 0; i < sz; i++) {
      TreeNode *node = q.front();
      q.pop();

      level_nodes.push_back(node);

      if (node->left) {
        q.push(node->left);
      }

      if (node->right) {
        q.push(node->right);
      }
    }

    for (int i = 0; i < sz - 1; i++) {
      level_nodes[i]->next = level_nodes[i + 1];
    }
  }
}

// O(n) /.O(n)
void traverse_using_next(TreeNode *root) {
  set_up_next_pointers(root);

  queue<TreeNode *> q;
  q.push(root);

  while (!q.empty()) {
    TreeNode *node = q.front();
    q.pop();

    TreeNode *curr = node;
    while (curr != nullptr) {
      cout << curr->val << " ";
      curr = curr->next;
    }
    cout << "\n";

    if (node->left) {
      q.push(node->left);
    } else if (node->right) {
      q.push(node->right);
    }
  }
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
    traverse_using_next(root);
  }

  return 0;
}