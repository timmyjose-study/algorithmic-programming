#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

// O(2^n) / O(2^n)
vector<vector<int>> subsets(const vector<int> &a) {
  vector<vector<int>> all_subs;
  all_subs.push_back({});

  for (int e : a) {
    int n = all_subs.size();
    for (int i = 0; i < n; i++) {
      vector<int> curr_sub = all_subs[i];
      curr_sub.push_back(e);
      all_subs.emplace_back(curr_sub);
    }
  }

  return all_subs;
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