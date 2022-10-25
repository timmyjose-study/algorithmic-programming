#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto swap = [](vector<int> &a, int x, int y) {
    int t = a[x];
    a[x] = a[y];
    a[y] = t;
  };

  int n, m, d;
  vector<vector<int>> a;

  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    vector<int> v;
    for (int j = 0; j < m; j++) {
      cin >> d;
      v.emplace_back(d);
    }
    a.emplace_back(v);
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0, k = m - 1; j < k; j++, k--) {
      swap(a[i], j, k);
    }
  }

  for (auto r : a) {
    for (int d : r) {
      cout << d << " ";
    }
    cout << "\n";
  }

  return 0;
}