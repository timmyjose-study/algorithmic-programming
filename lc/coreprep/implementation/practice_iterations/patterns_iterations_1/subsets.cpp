#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(2n) / O(2n)
vector<vector<int>> subsets(const vector<int> &a) {
  vector<vector<int>> res;
  res.push_back(vector<int>{});

  for (int e : a) {
    vector<vector<int>> prev = res;

    for (auto v : prev) {
      v.push_back(e);
      res.emplace_back(v);
    }
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = subsets(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}