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
vector<vector<int>> subsets_with_duplicates(vector<int> &a) {
  sort(a.begin(), a.end());

  vector<vector<int>> res;
  res.push_back(vector<int>{});

  int end = -1;
  for (int i = 0; i < a.size(); i++) {
    vector<vector<int>> prev = res;
    int start = 0;

    if (i > 0 && a[i] == a[i - 1]) {
      start = end;
    }
    end = prev.size();

    for (int j = start; j < prev.size(); j++) {
      prev[j].push_back(a[i]);
      res.emplace_back(prev[j]);
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

    auto res = subsets_with_duplicates(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}