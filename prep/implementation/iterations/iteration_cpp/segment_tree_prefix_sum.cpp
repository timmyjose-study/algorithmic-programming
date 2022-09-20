#include <algorithm>
#include <iostream>
#include <string>
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
    tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
  }
}

int query(const vector<int> &tree, int node, int start, int end, int l, int r) {
  if (l > end || r < start) {
    return 0;
  }

  if (l <= start && end <= r) {
    return tree[node];
  }

  int mid = start + (end - start) / 2;
  int lval = query(tree, 2 * node + 1, start, mid, l, r);
  int rval = query(tree, 2 * node + 2, mid + 1, end, l, r);

  return lval + rval;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, l, r;
  cin >> n;

  vector<int> a(n), b(n);
  vector<int> tree(4 * n);

  for (int i = 0; i < n; i++) {
    cin >> a[i];
    b[i] = a[i];
  }

  for (int i = 1; i < n; i++) {
    b[i] += b[i - 1];
  }

  fill(tree.begin(), tree.end(), 0);

  build(tree, 0, 0, n - 1, a);

  cin >> nq;
  while (nq--) {
    cin >> l >> r;
    int ps = (l == 0 ? b[r] : b[r] - b[l - 1]);
    int ss = query(tree, 0, 0, n - 1, l, r);

    cout << ps << " " << ss << "\n";
  }

  return 0;
}