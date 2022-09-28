#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

void build(vector<int> &tree, int node, int start, int end,
           const vector<int> &a) {
  if (start == end) {
    tree[node] = a[start];
  } else {
    int mid = start + (end - start) / 2;
    build(tree, 2 * node + 1, start, mid, a);
    build(tree, 2 * node + 2, mid + 1, end, a);
    tree[node] = min(tree[2 * node + 1], tree[2 * node + 2]);
  }
}

void update(vector<int> &tree, int node, int start, int end, int idx, int val,
            vector<int> &a) {
  if (start == end) {
    tree[node] = val;
    a[idx] = val;
  } else {
    int mid = start + (end - start) / 2;
    if (start <= idx && idx <= mid) {
      update(tree, 2 * node + 1, start, mid, idx, val, a);
    } else {
      update(tree, 2 * node + 2, mid + 1, end, idx, val, a);
    }

    tree[node] = min(tree[2 * node + 1], tree[2 * node + 2]);
  }
}

int query(const vector<int> &tree, int node, int start, int end, int l, int r) {
  if (l > end || r < start) {
    return numeric_limits<int>::max();
  }

  if (l <= start && end <= r) {
    return tree[node];
  }

  int mid = start + (end - start) / 2;
  int lval = query(tree, 2 * node + 1, start, mid, l, r);
  int rval = query(tree, 2 * node + 2, mid + 1, end, l, r);

  return min(lval, rval);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, l, r;
  cin >> n >> nq;

  vector<int> a(n), tree(4 * n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  fill(tree.begin(), tree.end(), 0);

  build(tree, 0, 0, n - 1, a);

  char op;
  while (nq--) {
    cin >> op >> l >> r;

    if (op == 'u') {
      update(tree, 0, 0, n - 1, l - 1, r, a);
    } else {
      cout << query(tree, 0, 0, n - 1, l - 1, r - 1) << "\n";
    }
  }

  return 0;
}